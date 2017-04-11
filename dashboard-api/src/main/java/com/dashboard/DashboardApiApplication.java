package com.dashboard;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringCloudApplication
@EnableFeignClients
@RibbonClient(name = "CHECKOUT-SERVICE", configuration = CheckoutConfiguration.class)
public class DashboardApiApplication {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Order(1)
	@Bean
	CommandLineRunner dc(DiscoveryClient discoveryClient){
		return args -> discoveryClient.getInstances("CHECKOUT-SERVICE").forEach(si -> {
			System.out.println(String.format("(%s) %s:%s",si.getServiceId(),si.getHost(),si.getPort()));
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(DashboardApiApplication.class, args);
	}
}

@Order(1)
@Component
class DiscoveryClientExample implements CommandLineRunner {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("------------------------------");
		System.out.println("DiscoveryClient Example");
		System.out.println("Order 1 : ");
		discoveryClient.getInstances("CHECKOUT-SERVICE").forEach((ServiceInstance s) -> {
			System.out.println(String.format("(%s) %s:%s",s.getHost(),s.getUri(),s.getPort()));
		});
	}
}

@Order(2)
@Component
class RestTemplateExample implements CommandLineRunner {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("------------------------------");
		System.out.println("RestTemplate Example");
		System.out.println("Order 2 @ RestTemplate : ");

		ParameterizedTypeReference<List<com.dashboard.model.Order>> ordersResponseType =
				new ParameterizedTypeReference<List<com.dashboard.model.Order>>() {};

		ResponseEntity<List<com.dashboard.model.Order>> orders = this.restTemplate.exchange(
				"http://CHECKOUT-SERVICE/checkout/orders/{username}",
				HttpMethod.GET, null, ordersResponseType, (Object) "yrodda");
		orders.getBody().forEach(System.out::println);

		System.out.println("------------------------------");
	}
}

@Order(3)
@Component
class FeignClientExample implements CommandLineRunner {

	@Autowired
	private OrderApiClient orderApiClient;


	@Override
	public void run(String... strings) throws Exception {

		System.out.println("------------------------------");
		System.out.println("Feign Example");
		System.out.println("Order 3 @ Feign : ");
		this.orderApiClient.getOrdersUsingFeign("yrodda").forEach(System.out::println);
	}
}

class CheckoutConfiguration {

	@Autowired
	IClientConfig ribbonClientConfig;

	@Bean
	public IPing ribbonPing(IClientConfig config) {
		return new PingUrl();
	}

	@Bean
	public IRule ribbonRule(IClientConfig config) {
		return new AvailabilityFilteringRule();
	}

}

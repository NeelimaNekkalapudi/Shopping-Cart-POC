package com.dashboard.controller;

import com.dashboard.OrderApiClient;
import com.dashboard.model.Order;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class DashBoardController {

    @Autowired
    OrderApiClient orderApiClient;

    @Autowired
    private RestTemplate restTemplate;

    private Collection<Order> getOrdersFallback(String userName){
        System.out.println("getOrdersFallback");
        return Arrays.asList();
    }

    @HystrixCommand(fallbackMethod = "getOrdersFallback")
    @RequestMapping(method = RequestMethod.GET, value = "/orders/{userName}")
    public Collection<Order> getOrders(@PathVariable("userName") String userName){
        Collection<Order> ordersList = orderApiClient.getOrdersUsingFeign(userName);

        return ordersList;
    }

    private Collection<Order> getOrdersByRestFallback(String userName){
        System.out.println("getOrdersByRestFallback");
        return Arrays.asList();
    }

    @HystrixCommand(fallbackMethod = "getOrdersByRestFallback")
    @RequestMapping(method = RequestMethod.GET, value = "/rest/orders/{userName}")
    public Collection<Order> getOrdersByRest(@PathVariable("userName") String userName){
        ParameterizedTypeReference<Collection<Order>> ordersResponseType =
                new ParameterizedTypeReference<Collection<Order>>() {};

        ResponseEntity<Collection<Order>> orders = this.restTemplate.exchange(
                "http://CHECKOUT-SERVICE/checkout/orders/{username}",
                HttpMethod.GET, null, ordersResponseType, (Object) "yrodda");

        Collection<Order> ordersList = orders.getBody();
        return ordersList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getInstanceDetails")
    public String getInstanceDetails(){
        return orderApiClient.getInstanceDetails();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getInstanceDetailsByRest")
    public String getInstanceDetailsByRest(){

        ResponseEntity<String> response= restTemplate.exchange("http://CHECKOUT-SERVICE/checkout/instance",HttpMethod.GET,null,String.class);

        return response.getBody();
    }
}


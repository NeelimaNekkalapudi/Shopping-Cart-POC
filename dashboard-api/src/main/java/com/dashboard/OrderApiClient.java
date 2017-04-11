package com.dashboard;

import com.dashboard.model.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

@FeignClient("CHECKOUT-SERVICE")
public interface OrderApiClient {

    @RequestMapping(method = RequestMethod.GET,value = "/checkout/orders/{username}")
    Collection<Order> getOrdersUsingFeign(@PathVariable("username") String username);

    @RequestMapping(method = RequestMethod.GET,value = "/checkout/instance")
    String getInstanceDetails();
}

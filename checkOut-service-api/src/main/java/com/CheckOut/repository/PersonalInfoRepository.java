package com.CheckOut.repository;

import com.CheckOut.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by kvajramani on 28-03-2017.
 */
@Repository
public interface PersonalInfoRepository extends CrudRepository<Order,String> {

    public Order getOrderById(@Param("id") String id);

    public Iterable<Order> getOrderByUsername(@Param("username") String username);

    public Order save(Order order);
}

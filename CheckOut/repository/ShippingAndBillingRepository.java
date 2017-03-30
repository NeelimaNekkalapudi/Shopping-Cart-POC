package com.CheckOut.repository;

import com.CheckOut.model.Order;
import com.CheckOut.repository.PersonalInfoRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by kvajramani on 28-03-2017.
 */
public interface ShippingAndBillingRepository extends CrudRepository<Order,String>,PersonalInfoRepository {

}

package com.cda.pc.Repository;

import org.springframework.data.repository.CrudRepository;

import com.cda.pc.Models.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
	
}

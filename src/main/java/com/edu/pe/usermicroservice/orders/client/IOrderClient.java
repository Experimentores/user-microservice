package com.edu.pe.usermicroservice.orders.client;

import com.edu.pe.usermicroservice.orders.domain.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "order-microservice", path = "/api/tripstore/v1/orders/")
public interface IOrderClient {
    @GetMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long id);
    @DeleteMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<Order>> deleteOrdersByUserId(@PathVariable Long id);
}

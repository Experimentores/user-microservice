package com.edu.pe.usermicroservice.orders.client;

import com.crudjpa.client.IHealthClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${tripstore.orders-service.name}", path = "${tripstore.orders-service.path}")
public interface IOrderClient extends IHealthClient {
    @DeleteMapping(value = "users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<?>> deleteOrdersByUserId(@PathVariable Long id);
}

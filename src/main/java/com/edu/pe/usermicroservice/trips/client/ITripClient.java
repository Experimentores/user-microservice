package com.edu.pe.usermicroservice.trips.client;

import com.crudjpa.client.IHealthClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "${tripstore.trips-service.name}",
        path = "${tripstore.trips-service.path}")
public interface ITripClient extends IHealthClient {
    @DeleteMapping("users/{id}")
    ResponseEntity<List<?>> deleteTripByUserId(@PathVariable Long id);

}

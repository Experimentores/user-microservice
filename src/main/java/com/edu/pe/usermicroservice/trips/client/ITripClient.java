package com.edu.pe.usermicroservice.trips.client;

import com.edu.pe.usermicroservice.trips.domain.model.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "${tripstore.trips-service.name}",
        path = "${tripstore.trips-service.path}")
public interface ITripClient {
    @GetMapping(value = "users/{id}")
    ResponseEntity<List<Trip>> getTrips(@PathVariable Long id);
    @DeleteMapping("users/{id}")
    ResponseEntity<List<Trip>> deleteTripByUserId(@PathVariable Long id);
}

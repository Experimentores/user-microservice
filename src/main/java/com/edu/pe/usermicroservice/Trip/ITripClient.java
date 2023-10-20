package com.edu.pe.usermicroservice.Trip;

import com.edu.pe.usermicroservice.model.Trip;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name = "trip-service")
public interface ITripClient {
    @GetMapping(value = "search/")
    ResponseEntity<List<Trip>> searchTrip(@RequestParam() Long userId);
    @DeleteMapping("delete/")
    ResponseEntity<List<Trip>> deleteTripByUserId(@RequestParam Long userId);
}

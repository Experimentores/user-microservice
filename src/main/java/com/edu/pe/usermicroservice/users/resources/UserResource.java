package com.edu.pe.usermicroservice.users.resources;

import com.edu.pe.usermicroservice.trips.domain.model.Trip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data()
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String username;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private List<Trip> trips;
}

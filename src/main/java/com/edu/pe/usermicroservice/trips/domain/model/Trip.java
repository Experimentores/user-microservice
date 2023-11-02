package com.edu.pe.usermicroservice.trips.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private Long id;
    private String origin;
    private String destination;
    private Date date;
}

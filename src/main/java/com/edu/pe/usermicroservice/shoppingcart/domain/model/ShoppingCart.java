package com.edu.pe.usermicroservice.shoppingcart.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private Long id;
    private LocalDateTime createdAt;
    private String status;
}

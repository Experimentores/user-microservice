package com.edu.pe.usermicroservice.orders.domain.model;

import com.edu.pe.usermicroservice.shoppingcart.domain.model.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data()
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long id;
    private LocalDate date;
    private String waitingTime;
    private Double totalPrice;
    private String orderStatus;
    private String paymentMethod;
    private Double paymentAmount;
    private ShoppingCart shoppingCart;
}

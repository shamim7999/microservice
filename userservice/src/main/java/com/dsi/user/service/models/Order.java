package com.dsi.user.service.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.UUID;

@Getter
@Setter
@Entity @Table(name = "orders")
@ToString
public class Order extends RepresentationModel<Order> {
    @Id
    private String orderId = UUID.randomUUID().toString();
    private double price;
    private int quantity;

    public void addSelfLink() {
        Link selfLink = Link.of("/orders/" + this.orderId).withSelfRel();
        add(selfLink);
    }
}

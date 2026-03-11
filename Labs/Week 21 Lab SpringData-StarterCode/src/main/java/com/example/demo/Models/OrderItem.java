package com.example.demo.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "seller_produce_id")
    private SellerProduce sellerProduce;

    public OrderItem() {
    }

    public OrderItem(Order order, SellerProduce sellerProduce, int quantity) {
        this.order = order;
        this.sellerProduce = sellerProduce;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public SellerProduce getSellerProduce() {
        return sellerProduce;
    }

    public void setSellerProduce(SellerProduce sellerProduce) {
        this.sellerProduce = sellerProduce;
    }
}
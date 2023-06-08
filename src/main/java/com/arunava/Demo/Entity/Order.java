package com.arunava.Demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private int orderId;
    @Column(name = "CUSTOMER_ID")
    private int customerId;
    @Column(name = "AMOUNT")
    private int amount;
    @Column(name = "ORDER_DATE")
    private String orderDate;
    public Order(){}
    public Order(
            int customerId, String orderDate, int amount
    ){
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.amount = amount;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}

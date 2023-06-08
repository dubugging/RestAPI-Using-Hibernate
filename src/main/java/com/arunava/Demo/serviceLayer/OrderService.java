package com.arunava.Demo.serviceLayer;

import com.arunava.Demo.Entity.Order;

import java.util.List;

public interface OrderService {
    void save(Order order);
    void updateAmount(int id, int amount);
    void deleteById(int id);
    Order findById(int id);
    List<Order> getAllOrders();
}

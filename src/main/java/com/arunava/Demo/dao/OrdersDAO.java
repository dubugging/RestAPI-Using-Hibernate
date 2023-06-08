package com.arunava.Demo.dao;

import com.arunava.Demo.Entity.Order;

import java.util.List;

public interface OrdersDAO {
    void save(Order order);
    void updateAmount(int id, int amount);
    void deleteById(int id);
    Order findById(int id);
    List<Order> getAllOrder();
}

package com.arunava.Demo.serviceLayer;

import com.arunava.Demo.Entity.Order;
import com.arunava.Demo.dao.OrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private final OrdersDAO ordersDAO;
    @Autowired
    public OrderServiceImpl(OrdersDAO od){
        ordersDAO = od;
    }
    @Override
    @Transactional
    public void save(Order order) {
        ordersDAO.save(order);
    }
    @Override
    @Transactional
    public void updateAmount(int id, int amount) {
        ordersDAO.updateAmount(id, amount);
    }
    @Override
    @Transactional
    public void deleteById(int id) {
        ordersDAO.deleteById(id);
    }
    @Override
    public Order findById(int id) {
        return ordersDAO.findById(id);
    }
    @Override
    public List<Order> getAllOrders() {
        return ordersDAO.getAllOrder();
    }
}

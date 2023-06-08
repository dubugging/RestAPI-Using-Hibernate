package com.arunava.Demo.rest;

import com.arunava.Demo.Entity.Order;
import com.arunava.Demo.dao.OrdersDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrdersDAO ordersDAO;
    @Autowired
    public OrderController(OrdersDAO dao){
        ordersDAO = dao;
    }
    @PostMapping("/add/{customerId}/{orderDate}/{amount}")
    public void addOrder(
            @PathVariable int customerId,
            @PathVariable String orderDate,
            @PathVariable int amount
    ){
        ordersDAO.save(new Order(customerId, orderDate, amount));
    }
    @PutMapping("/update/{id}/{amount}")
    public void updateAmount(
            @PathVariable int id,
            @PathVariable int amount
    ){
        ordersDAO.updateAmount(id, amount);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        ordersDAO.deleteById(id);
    }
    @GetMapping("/allOrders")
    public List<Order> getAllOrder(){
        return ordersDAO.getAllOrder();
    }
    @GetMapping("/getOrder/{id}")
    public Order getOrderById(@PathVariable int id){
        return ordersDAO.findById(id);
    }
}

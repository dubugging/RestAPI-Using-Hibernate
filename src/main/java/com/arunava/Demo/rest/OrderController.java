package com.arunava.Demo.rest;

import com.arunava.Demo.Entity.Order;
import com.arunava.Demo.dao.OrdersDAO;
import com.arunava.Demo.serviceLayer.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService os){
        orderService = os;
    }
    @PostMapping("/add/{customerId}/{orderDate}/{amount}")
    public void addOrder(
            @PathVariable int customerId,
            @PathVariable String orderDate,
            @PathVariable int amount
    ){
        orderService.save(new Order(customerId, orderDate, amount));
    }
    @PutMapping("/update/{id}/{amount}")
    public void updateAmount(
            @PathVariable int id,
            @PathVariable int amount
    ){
        orderService.updateAmount(id, amount);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        orderService.deleteById(id);
    }
    @GetMapping("/allOrders")
    public List<Order> getAllOrder(){
        return orderService.getAllOrders();
    }
    @GetMapping("/getOrder/{id}")
    public Order getOrderById(@PathVariable int id){
        return orderService.findById(id);
    }
}

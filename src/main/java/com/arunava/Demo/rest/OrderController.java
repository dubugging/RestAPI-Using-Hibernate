package com.arunava.Demo.rest;

import com.arunava.Demo.Entity.Order;
import com.arunava.Demo.serviceLayer.OrderService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private static final Logger logger = Logger.getLogger(OrderController.class);
    {
        BasicConfigurator.configure();
    }
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
        logger.info("Inserted new row");
    }
    @PutMapping("/update/{id}/{amount}")
    public void updateAmount(
            @PathVariable int id,
            @PathVariable int amount
    ){
        orderService.updateAmount(id, amount);
        logger.info("Updated id="+id+" and amount is "+amount);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        orderService.deleteById(id);
        logger.info("Deleted records of id="+id);
    }
    @GetMapping("/allOrders")
    public List<Order> getAllOrder(){
        logger.info("Showing all records");
        return orderService.getAllOrders();
    }
    @GetMapping("/getOrder/{id}")
    public Order getOrderById(@PathVariable int id){
        logger.info("Showing details of id="+id);
        return orderService.findById(id);
    }
}

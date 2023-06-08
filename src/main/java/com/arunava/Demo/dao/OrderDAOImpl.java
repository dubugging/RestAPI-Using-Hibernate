package com.arunava.Demo.dao;

import com.arunava.Demo.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDAOImpl implements OrdersDAO{
    private final EntityManager em;
    @Autowired
    public OrderDAOImpl(EntityManager entityManager){
        em = entityManager;
    }
    @Override
    public void save(Order order) {
        em.persist(order);
    }
    @Override
    public void updateAmount(int id, int amount) {
        var order = this.findById(id);
        order.setAmount(35);
        em.merge(order);
    }
    @Override
    public void deleteById(int id) {
        em.remove(this.findById(id));
    }
    @Override
    public Order findById(int id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getAllOrder() {
        TypedQuery<Order> query = em.createQuery("FROM Order", Order.class);
        return query.getResultList();
    }
}

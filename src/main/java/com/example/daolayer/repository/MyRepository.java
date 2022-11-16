package com.example.daolayer.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MyRepository {
    @PersistenceContext
    private EntityManager manager;


    public List<String> getProductName(String name) {
        return manager.createQuery("select o.product from Order as o " +
                        "left join Customer as c on o.id = c.id where lower(c.name) = lower(:name)", String.class)
                .setParameter("name", name).getResultList();
    }
}

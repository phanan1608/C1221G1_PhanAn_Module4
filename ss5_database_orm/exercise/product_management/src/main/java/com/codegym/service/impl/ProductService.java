package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    static Map<Integer, Product> products;

    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.conf.xml")
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery = entityManager.createQuery("select p from Product p",Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product AS p WHERE p.id = :id", Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Product product) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.remove(findById(id));
        entityTransaction.commit();
    }
}

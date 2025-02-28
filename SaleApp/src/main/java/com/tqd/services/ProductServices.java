/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.services;

import com.tqd.englishapp.HibernateUtils;
import com.tqd.pojo.Product;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PHAT
 */
public class ProductServices {

    public List<Product> getProducts() {
        List<Product> prods = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtils.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Product", Product.class);
            prods = q.getResultList();
            transaction.commit();
        } catch(HibernateException ex){
            if(transaction != null) transaction.rollback();
        }
        return prods;
    }
}

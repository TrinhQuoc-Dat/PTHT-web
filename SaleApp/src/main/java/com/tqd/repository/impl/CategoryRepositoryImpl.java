/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.repository.impl;

import com.tqd.pojo.Category;
import com.tqd.saleapp.HibernateUltils;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class CategoryRepositoryImpl {
    public List<Category> getCategories(){
        Session s = HibernateUltils.getFACTORY().openSession();
        Query q = s.createQuery("From Category", Category.class);
        return q.getResultList();
    }
}

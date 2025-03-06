/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.repository.impl;

import com.tqd.pojo.Product;
import com.tqd.saleapp.HibernateUltils;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
    private static Integer PAGE_SIZE = 6;
    public List<Product> getProducts(Map<String, String> params) {
        try (Session s = HibernateUltils.getFACTORY().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Product> q = b.createQuery(Product.class);
            Root root = q.from(Product.class);
            List<Predicate> predicates = new ArrayList<>();

            if (params != null) {
                if (params.get("kw") != null && !params.get("kw").isEmpty()) {
                    predicates.add(b.like(root.get("name"), "%" + params.get("kw") + "%"));
                }
                String priceFrom = params.get("priceFrom");
                if (priceFrom != null && !priceFrom.isEmpty()) {
                    predicates.add(b.greaterThanOrEqualTo(root.get("price"),  
                            Double.parseDouble(priceFrom)));
                }
                
                String priceTo = params.get("priceTo");
                if (priceTo != null && !priceTo.isEmpty()) {
                    predicates.add((Predicate) b.lessThanOrEqualTo(root.get("price"),  
                            Double.parseDouble(priceTo)));
                }
                
                String category = params.get("categoryId");
                if (category != null && !category.isEmpty()){
                    predicates.add(b.equal(root.get("categoryId").as(Integer.class), category));
                }
            }
            
            q.select(root).where(b.and(predicates.toArray(new Predicate[0])));
            Query query = s.createQuery(q);

            if (params != null){
                int page = params.get("page") != null ? Integer.parseInt("page") : 1;
                int page2 = Integer.parseInt(params.getOrDefault("page", "1"));
                int start = (page -1 ) * PAGE_SIZE;
                
                query.setFirstResult(start);
                query.setMaxResults(PAGE_SIZE);
         
            }
            
            return query.getResultList();

        }
    }
}

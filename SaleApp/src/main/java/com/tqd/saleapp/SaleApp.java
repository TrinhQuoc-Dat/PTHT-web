/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tqd.saleapp;

import com.tqd.repository.impl.CategoryRepositoryImpl;
import com.tqd.repository.impl.ProductRepositoryImpl;
import com.tqd.repository.impl.StatsRepositoryImpl;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class SaleApp {

    public static void main(String[] args) {
        StatsRepositoryImpl s = new StatsRepositoryImpl();
        s.StatsRevenueByProducts().forEach(x -> System.out.printf("%d - %s - %d\n", x[0], x[1], x[2]));
        
        
//        CategoryRepositoryImpl r = new CategoryRepositoryImpl();
//        r.getCategories().forEach(x -> System.out.println(x.getName()));
//
//        Map<String, String> params = new HashMap<>();
//        params.put("kw", "iphone"); 
//        params.put("priceFrom", "10000000");   
//        params.put("priceTo", "50000000");   
//        params.put("categoryId", "2");   
//
//        ProductRepositoryImpl r2 = new ProductRepositoryImpl();
//        r2.getProducts(params).forEach(x -> System.out.printf("%d - %s - %d\n",
//                x.getId(), x.getName(), x.getPrice()));

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.saleapp;

import com.tqd.pojo.Category;
import com.tqd.pojo.Comment;
import com.tqd.pojo.OrderDetail;
import com.tqd.pojo.ProdTag;
import com.tqd.pojo.Product;
import com.tqd.pojo.SaleOrder;
import com.tqd.pojo.Tag;
import com.tqd.pojo.User;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author admin
 */
public class HibernateUltils {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties prod = new Properties();
        prod.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");    
        prod.put(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        prod.put(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb");   
        prod.put(Environment.JAKARTA_JDBC_USER, "root");
        prod.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
        prod.put(Environment.SHOW_SQL, "true");

        conf.setProperties(prod);
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(ProdTag.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);
        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        
        FACTORY = conf.buildSessionFactory(serviceRegistry);
        
    }
    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
    
    
}

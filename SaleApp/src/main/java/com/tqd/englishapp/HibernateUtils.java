/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.englishapp;

import com.tqd.pojo.Category;
import com.tqd.pojo.Comment;
import com.tqd.pojo.OrderDetail;
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
 * @author PHAT
 */
public class HibernateUtils {

    private final static SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties prop = new Properties();
        prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        prop.setProperty(Environment.JAKARTA_JDBC_DRIVER, "com.mysql.cj.jdbc.Driver");
        prop.setProperty(Environment.JAKARTA_JDBC_USER, "root");
        prop.setProperty(Environment.JAKARTA_JDBC_PASSWORD,"Admin@123");
        prop.setProperty(Environment.JAKARTA_JDBC_URL, "jdbc:mysql://localhost/saledb_java");
        
        conf.addAnnotatedClass(Category.class);
        conf.addAnnotatedClass(Comment.class);
        conf.addAnnotatedClass(OrderDetail.class);
        conf.addAnnotatedClass(Product.class);
        conf.addAnnotatedClass(SaleOrder.class);
        conf.addAnnotatedClass(Tag.class);
        conf.addAnnotatedClass(User.class);

        
        conf.setProperties(prop);
        
        ServiceRegistry registry
                = new StandardServiceRegistryBuilder()
                        .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);
    }

    /**
     * @return the FACTORY
     */
    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author PHAT
 */
@Entity
@Table(name = "sale_order")
public class SaleOrder implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "created_date")
    private Date createDate;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    
    @ManyToMany
    @JoinTable(
        name = "order_detail",
        joinColumns = {
            @JoinColumn(name = "order_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "product_id")
        }
    )
    private Set<Product> products;
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the createDate
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate the createDate to set
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return the products
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * @param products the products to set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

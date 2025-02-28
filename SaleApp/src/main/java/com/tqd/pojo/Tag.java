/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author PHAT
 */
@Entity
@Table(name = "tag")
public class Tag implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String tagcol;

    @ManyToMany(mappedBy = "tags")
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tagcol
     */
    public String getTagcol() {
        return tagcol;
    }

    /**
     * @param tagcol the tagcol to set
     */
    public void setTagcol(String tagcol) {
        this.tagcol = tagcol;
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

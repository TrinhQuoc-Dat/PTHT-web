/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tqd.pojo;

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
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author PHAT
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    
    private BigDecimal price;
    private String manufacturer;
    private String image;
    private Date created_date;
    private Boolean active;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToMany
    @JoinTable(
        name = "comment",
        joinColumns = {
            @JoinColumn(name = "product_id")
        },
        inverseJoinColumns = {
            @JoinColumn(name = "user_id")
        }
    )
    private Set<User> users;
    
    @ManyToMany(mappedBy = "products")
    private Set<SaleOrder> orders;

    @ManyToMany
    @JoinTable(
            name = "prod_tag",
            joinColumns = {
                @JoinColumn(name = "product_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "tag_id")
            }
    )
    private Set<Tag> tags;
    
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * @param manufacturer the manufacturer to set
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the created_date
     */
    public Date getCreated_date() {
        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    /**
     * @return the active
     */
 

    /**
     * @return the categoryId
     */
    public Category getCategoryId() {
        return getCategory();
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(Category categoryId) {
        this.setCategory(categoryId);
    }

    /**
     * @return the category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * @return the users
     */
    public Set<User> getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }

    /**
     * @return the orders
     */
    public Set<SaleOrder> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(Set<SaleOrder> orders) {
        this.orders = orders;
    }

    /**
     * @return the tags
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }
}

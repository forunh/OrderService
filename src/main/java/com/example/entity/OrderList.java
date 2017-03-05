package com.example.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Entity
@Table(name="order_list")
public class OrderList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    private Integer price;
    private String address;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;
    @Transient
    private List<OrderMenu> orderMenus;

    public OrderList(){}
    public OrderList(Integer userId, Integer price, String address) {
        this.userId = userId;
        this.price = price;
        this.address = address;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setOrderMenus(List<OrderMenu> orderMenus ){
        this.orderMenus = orderMenus;
    }
    public List<OrderMenu> getOrderMenus (){
        return orderMenus;
    }
}
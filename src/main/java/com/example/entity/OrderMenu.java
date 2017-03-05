package com.example.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Entity
@Table(name="order_menu")
public class OrderMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "menu_id")
    private Integer menuId;
    private Integer quantity;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at")
    private Date createAt;

    public OrderMenu(){}
    public OrderMenu(Integer orderId, Integer menuId, Integer quantity) {
        this.orderId = orderId;
        this.menuId = menuId;
        this.quantity =quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
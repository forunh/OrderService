package com.example.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Forunh on 03-Mar-17.
 */
public class OrderMenuList {

    private Integer orderId;
//    private Integer userId;
//    private Integer price;
//    private String address;
    private List<Menu> menuList;
//    private Date createAt;

    public OrderMenuList(){}

    public Integer getOrderId(){
        return this.orderId;
    }
    public void setOrderId(Integer orderId){
        this.orderId=orderId;
    }
    public List<Menu> getMenuList(){
        return this.menuList;
    }
    public void setMenuList(List<Menu> menuList){
        this.menuList=menuList;
    }
//    public Integer getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Integer userId) {
//        this.userId = userId;
//    }
//
//    public Integer getPrice() {
//        return price;
//    }
//
//    public void setPrice(Integer price) {
//        this.price = price;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public Date getCreateAt() {
//        return createAt;
//    }
//
//    public void setCreateAt(Date createAt) {
//        this.createAt = createAt;
//    }


}

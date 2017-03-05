package com.example.entity;

import java.util.List;

/**
 * Created by Forunh on 03-Mar-17.
 */
public class Menu {

    private Integer menuId;
    private Integer quantity;

    public Menu(){}

    public Integer getMenuId(){
        return this.menuId;
    }
    public void setMenuId(Integer menuId){
        this.menuId=menuId;
    }
    public Integer getQuantity(){
        return this.quantity;
    }public void setQuantity(Integer quantity){
        this.quantity=quantity;
    }
}

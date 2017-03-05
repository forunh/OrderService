package com.example.service;


import com.example.entity.OrderMenu;

import java.util.List;

//import com.example.entity.OrderMenu;

/**
 * Created by Forunh on 01-Mar-17.
 */
public interface IOrderMenuService {
    List<OrderMenu> getOrderMenuByOrderId(Integer order_id);
    List<OrderMenu> getAllOrderMenu();
    OrderMenu addOrderMenu(OrderMenu orderMenu);


}

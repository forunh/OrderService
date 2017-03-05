package com.example.controller;

import com.example.entity.Menu;
import com.example.entity.OrderList;
import com.example.entity.OrderMenu;
import com.example.entity.OrderMenuList;

import com.example.service.IKitchenService;
import com.example.service.IOrderListService;
import com.example.service.IOrderMenuService;
import com.example.service.impl.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Forunh on 06-Mar-17.
 */
@RestController
@CrossOrigin
public class OrderController {

    @Autowired
    IOrderListService orderListService;
    @Autowired
    IOrderMenuService orderMenuService;


    @PostMapping(value = "/order")
    public OrderList addOrder(@RequestBody OrderList orderList) {
        orderListService.addOrderList(orderList);
        List<OrderMenu> orderMenus = orderList.getOrderMenus();
        KitchenService kitchenService = new KitchenService();

        for(Iterator<OrderMenu> i = orderMenus.iterator(); i.hasNext(); ) {
            OrderMenu orderMenu = i.next();
            orderMenu.setOrderId(orderList.getId());
            orderMenuService.addOrderMenu(orderMenu);
            kitchenService.addKitchen(orderMenu,orderList.getUserId());

        }
        return orderList;
    }
    @GetMapping("/order")
    public ResponseEntity getOrderByUserId(@RequestParam("userid") Integer user_id) {
        List<OrderList> orderLists = orderListService.getOrderListByuserId(user_id);
        for(Iterator<OrderList> i = orderLists.iterator(); i.hasNext(); ) {
            OrderList orderList = i.next();
            orderList.setOrderMenus(orderMenuService.getOrderMenuByOrderId(orderList.getId()));
        }
        return new ResponseEntity(orderLists, HttpStatus.OK);
    }

    @GetMapping("/all_order")
    public List<OrderList> getAllOrderList() {
        List<OrderList> orderLists = orderListService.getAllOrderList();
        for(Iterator<OrderList> i = orderLists.iterator(); i.hasNext(); ) {
            OrderList orderList = i.next();
            orderList.setOrderMenus(orderMenuService.getOrderMenuByOrderId(orderList.getId()));
        }
        return orderLists;
    }
}

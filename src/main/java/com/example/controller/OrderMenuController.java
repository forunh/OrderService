package com.example.controller;

import com.example.entity.Menu;
import com.example.entity.OrderMenu;
import com.example.entity.OrderMenuList;
import com.example.service.IOrderMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@RestController
@Table(name="order_menu")
@CrossOrigin

public class OrderMenuController {

    @Autowired
    IOrderMenuService orderMenuService;

//    @GetMapping("/")
//    public String index() {
//        return "Hello World";
//    }

    @GetMapping("/orderMenu")
    public ResponseEntity getOrderMenuByOrderId(@RequestParam("orderid") Integer order_id) {
        return new ResponseEntity(orderMenuService.getOrderMenuByOrderId(order_id), HttpStatus.OK);
    }

    @PostMapping(value = "/orderMenu")
    public OrderMenu addOrderMenu(@RequestBody OrderMenu orderMenu) {
        return orderMenuService.addOrderMenu(orderMenu);
    }

    @PostMapping(value = "/AddOrderMenu")
    public List<OrderMenu> addOrderMenu(@RequestBody OrderMenuList orderMenuList) {
        Integer orderId = orderMenuList.getOrderId();
        List<Menu> menuList = orderMenuList.getMenuList();
        List<OrderMenu> orderMenus = new ArrayList<OrderMenu>();

        for(Iterator<Menu> i = menuList.iterator(); i.hasNext(); ) {
            Menu menu = i.next();
            OrderMenu orderMenu = new OrderMenu(orderId,menu.getMenuId(),menu.getQuantity());
            orderMenus.add(orderMenuService.addOrderMenu(orderMenu));

//            System.out.println(item);
        }
        return orderMenus;
    }

    @GetMapping("/all_orderMenu")
    public List<OrderMenu> getAllOrderMenu() {
        List<OrderMenu> test = orderMenuService.getAllOrderMenu();
        return orderMenuService.getAllOrderMenu();
    }

}

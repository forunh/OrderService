package com.example.controller;

import com.example.entity.OrderList;
import com.example.service.IOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@RestController
@Table(name="order_list")
@CrossOrigin
public class OrderListController {

    @Autowired
    IOrderListService orderListService;

    @GetMapping("/")
    public String index() {
        return "Order Service";
    }

    @GetMapping("/orderList")
    public ResponseEntity getOrderListByUserId(@RequestParam("userid") Integer user_id) {
        return new ResponseEntity(orderListService.getOrderListByuserId(user_id), HttpStatus.OK);
    }
    @PostMapping(value = "/orderList")
    public OrderList addOrderList(@RequestBody OrderList orderList) {
        OrderList o = orderListService.addOrderList(orderList);
        return o;
    }

    @GetMapping("/all_orderList")
    public List<OrderList> getAllOrderList() {
        List<OrderList> test = orderListService.getAllOrderList();
        return orderListService.getAllOrderList();
    }

}

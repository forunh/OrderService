package com.example.service;

import com.example.entity.OrderList;
import org.hibernate.boot.model.source.spi.Orderable;

import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
public interface IOrderListService {
    List<OrderList> getOrderListByuserId(Integer user_id);
    List<OrderList> getAllOrderList();
    OrderList addOrderList(OrderList orderList);
}

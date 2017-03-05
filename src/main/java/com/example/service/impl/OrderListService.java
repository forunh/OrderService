package com.example.service.impl;

import com.example.entity.OrderList;
import com.example.repository.OrderListRepository;
import com.example.service.IOrderListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Service
public class OrderListService implements IOrderListService {
    @Autowired
    OrderListRepository orderListRepository;

    @Override
    public List<OrderList> getOrderListByuserId(Integer user_id) {
        return orderListRepository.findByUserId(user_id);
    }

    @Override
    public List<OrderList> getAllOrderList() {
        List<OrderList> all = orderListRepository.findAll();
        return all;
    }

    @Override
    public OrderList addOrderList(OrderList orderList) {
        try {
            return orderListRepository.save(orderList);
        }
        catch (Exception e) {
            return null;
        }
    }
}

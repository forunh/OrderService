package com.example.service.impl;

import com.example.entity.OrderMenu;
import com.example.repository.OrderMenuRepository;
import com.example.service.IOrderMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Service
public class OrderMenuService implements IOrderMenuService {
    @Autowired
    OrderMenuRepository orderMenuRepository;

    @Override
    public List<OrderMenu> getOrderMenuByOrderId(Integer order_id) {
        return orderMenuRepository.findByOrderId(order_id);
    }

    @Override
    public List<OrderMenu> getAllOrderMenu() {
        List<OrderMenu> all = orderMenuRepository.findAll();
        return all;
    }

    @Override
    public OrderMenu addOrderMenu(OrderMenu orderMenu) {
        try {
            return orderMenuRepository.save(orderMenu);
        }
        catch (Exception e) {
            return null;
        }
    }
}

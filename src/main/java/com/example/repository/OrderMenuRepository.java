package com.example.repository;

import com.example.entity.OrderMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Repository
public interface OrderMenuRepository extends JpaRepository<OrderMenu, Integer> {
    List<OrderMenu> findByOrderId(Integer order_id);

}

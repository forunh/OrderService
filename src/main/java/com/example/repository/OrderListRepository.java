package com.example.repository;

import com.example.entity.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;

/**
 * Created by Forunh on 01-Mar-17.
 */
@Repository
public interface OrderListRepository extends JpaRepository<OrderList, Integer> {
    List<OrderList> findByUserId(Integer user_id);

}

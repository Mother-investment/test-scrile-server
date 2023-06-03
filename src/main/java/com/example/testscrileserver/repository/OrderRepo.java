package com.example.testscrileserver.repository;

import com.example.testscrileserver.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<OrderEntity, Long> {
}

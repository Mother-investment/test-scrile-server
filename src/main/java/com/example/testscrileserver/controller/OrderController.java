package com.example.testscrileserver.controller;

import com.example.testscrileserver.entity.OrderEntity;
import com.example.testscrileserver.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderRepo orderRepo;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping
	public ResponseEntity postOrder(@RequestBody OrderEntity order) {
		try {
			orderRepo.save(order);
			return ResponseEntity.ok("Заказ успешно сохранен");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping
	public ResponseEntity getOrders() {
		try {
			Iterable<OrderEntity> orders = orderRepo.findAll();
			return ResponseEntity.ok(orders);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
}

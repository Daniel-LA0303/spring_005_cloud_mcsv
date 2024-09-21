package com.mx.mcsv.service.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.mcsv.service.car.entity.Car;
import com.mx.mcsv.service.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	CarService carService;

	@GetMapping
	public ResponseEntity<List<Car>> getAll() {
		List<Car> cars = carService.getAll();
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Car> getById(@PathVariable("id") int id) {
		Car car = carService.getCarById(id);
		if (car == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(car);
	}

	@GetMapping("/byuser/{userId}")
	public ResponseEntity<List<Car>> getByUserId(@PathVariable("userId") int userId) {
		List<Car> cars = carService.byUserId(userId);
		if (cars.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cars);
	}

	@PostMapping()
	public ResponseEntity<Car> save(@RequestBody Car car) {
		Car carNew = carService.save(car);
		return ResponseEntity.ok(carNew);
	}

}

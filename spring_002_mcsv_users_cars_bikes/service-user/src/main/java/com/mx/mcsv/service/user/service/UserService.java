package com.mx.mcsv.service.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mx.mcsv.service.user.entity.User;
import com.mx.mcsv.service.user.feignclients.BikeFeignClient;
import com.mx.mcsv.service.user.feignclients.CarFeignClient;
import com.mx.mcsv.service.user.model.Bike;
import com.mx.mcsv.service.user.model.Car;
import com.mx.mcsv.service.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	CarFeignClient carFeignClient;

	@Autowired
	BikeFeignClient bikeFeignClient;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public List<Bike> getBikes(int userId) {
		List<Bike> bikes = restTemplate.getForObject("http://service-bike/bike/byuser/" + userId, List.class);
		return bikes;
	}

	public List<Car> getCars(int userId) {
		List<Car> cars = restTemplate.getForObject("http://service-car/car/byuser/" + userId, List.class);
		return cars;
	}

	public Map<String, Object> getUserAndVehicles(int userId) {
		Map<String, Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		if (user == null) {
			result.put("Mensaje", "no existe el usuario");
			return result;
		}
		result.put("User", user);
		List<Car> cars = carFeignClient.getCars(userId);
		if (cars.isEmpty()) {
			result.put("Cars", "ese user no tiene coches");
		} else {
			result.put("Cars", cars);
		}
		List<Bike> bikes = bikeFeignClient.getBikes(userId);
		if (bikes.isEmpty()) {
			result.put("Bikes", "ese user no tiene motos");
		} else {
			result.put("Bikes", bikes);
		}
		return result;
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User userNew = userRepository.save(user);
		return userNew;
	}

	public Bike saveBike(int userId, Bike bike) {
		bike.setUserId(userId);
		Bike bikeNew = bikeFeignClient.save(bike);
		return bikeNew;
	}

	public Car saveCar(int userId, Car car) {
		car.setUserId(userId);
		Car carNew = carFeignClient.save(car);
		return carNew;
	}
}
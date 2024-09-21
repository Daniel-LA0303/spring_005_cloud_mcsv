package com.mx.mcsv.service.user.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.mx.mcsv.service.user.model.Car;

@FeignClient(name = "service-car", url = "http://localhost:8002/car")
public interface CarFeignClient {

	@GetMapping("/byuser/{userId}")
	List<Car> getCars(@PathVariable("userId") int userId);

	@PostMapping()
	Car save(@RequestBody Car car);
}

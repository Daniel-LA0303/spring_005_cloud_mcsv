package com.mx.mcsv.service.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

	private String brand;

	private String model;

	public Car() {
	}

	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

}

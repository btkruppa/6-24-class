package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Brand;
import com.revature.services.BrandService;

@RestController
@RequestMapping("/brands")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@GetMapping("/icecream/toppings/name/{toppingName}")
	public List<Brand> findBrandsContainingTopping(@PathVariable String toppingName) {
		return brandService.findByIceCreamToppingsName(toppingName);
	}
}

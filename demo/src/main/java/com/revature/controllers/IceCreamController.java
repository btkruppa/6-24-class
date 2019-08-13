package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Flavor;
import com.revature.models.IceCream;
import com.revature.services.IceCreamService;

@RestController
@RequestMapping("icecream")
public class IceCreamController {

	@Autowired
	private IceCreamService iceCreamService;

	@GetMapping
	public List<IceCream> findAll() {
		return iceCreamService.findAll();
	}

	@GetMapping("/brand/name/{brandName}")
	public List<IceCream> findByBrandName(@PathVariable String brandName) {
		return iceCreamService.findByBrandName(brandName);
	}

	@GetMapping("/flavors/name/{flavorName}")
	public List<IceCream> findByFlavorsName(@PathVariable String flavorName) {
		return iceCreamService.findByFlavorsName(flavorName);
	}

	@PostMapping("{iceCreamId}/flavors")
	public ResponseEntity<IceCream> addFlavorToIceCream(@PathVariable int iceCreamId, @RequestBody Flavor flav) {
		IceCream updatedIceCream = iceCreamService.addFlavorToIceCream(iceCreamId, flav);
		ResponseEntity<IceCream> resp = new ResponseEntity<IceCream>(updatedIceCream, HttpStatus.CREATED);
		return resp;
	}

	@PutMapping
	public IceCream update(@RequestBody IceCream ic) {
		return iceCreamService.update(ic);
	}
}

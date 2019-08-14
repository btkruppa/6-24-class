package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Brand;
import com.revature.repos.BrandRepo;

@Service
public class BrandService {

	@Autowired
	private BrandRepo br;

	public List<Brand> findByIceCreamToppingsName(String toppingName) {
		return br.findByIceCreamToppingsName(toppingName);
	}
}

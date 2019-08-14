package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Brand;

public interface BrandRepo extends JpaRepository<Brand, Integer> {
	List<Brand> findByIceCreamToppingsName(String toppingName);
}

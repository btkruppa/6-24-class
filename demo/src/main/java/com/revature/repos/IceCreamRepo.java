package com.revature.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.IceCream;

public interface IceCreamRepo extends JpaRepository<IceCream, Integer> {

	List<IceCream> findByBrandName(String brandName);

	List<IceCream> findByFlavorsName(String flavorName);
}

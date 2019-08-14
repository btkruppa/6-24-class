package com.revature.repos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.IceCream;

public interface IceCreamRepo extends JpaRepository<IceCream, Integer> {

	Page<IceCream> findByBrandName(String brandName, Pageable page);

	List<IceCream> findByFlavorsName(String flavorName);

}

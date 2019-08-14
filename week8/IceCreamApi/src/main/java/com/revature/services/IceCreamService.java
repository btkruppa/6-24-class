package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.revature.models.Flavor;
import com.revature.models.IceCream;
import com.revature.repos.IceCreamRepo;

@Service
public class IceCreamService {

	@Autowired
	private IceCreamRepo iceCreamRepo;

	public Page<IceCream> findAll(int pageNumber) {
		Pageable page = PageRequest.of(pageNumber, 5);
		return iceCreamRepo.findAll(page);
	}

	public Page<IceCream> findByBrandName(String brandName, int pageNumber) {
		Pageable page = PageRequest.of(pageNumber, 5);
		return iceCreamRepo.findByBrandName(brandName, page);
	}

	public List<IceCream> findByFlavorsName(String flavorName) {
		return iceCreamRepo.findByFlavorsName(flavorName);
	}

	@Transactional
	public IceCream addFlavorToIceCream(int iceCreamId, Flavor flav) {
		IceCream ic = iceCreamRepo.getOne(iceCreamId);
		ic.getFlavors().add(flav);
		return ic;
	}

	public IceCream update(IceCream ic) {
		return iceCreamRepo.saveAndFlush(ic);
	}
}

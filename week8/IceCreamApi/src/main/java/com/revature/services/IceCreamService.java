package com.revature.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Flavor;
import com.revature.models.IceCream;
import com.revature.repos.IceCreamRepo;

@Service
public class IceCreamService {

	@Autowired
	private IceCreamRepo iceCreamRepo;

	public List<IceCream> findAll() {
		return iceCreamRepo.findAll();
	}

	public List<IceCream> findByBrandName(String brandName) {
		return iceCreamRepo.findByBrandName(brandName);
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

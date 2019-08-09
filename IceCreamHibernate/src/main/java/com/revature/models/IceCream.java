package com.revature.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ice_cream")
@NamedQueries({
	@NamedQuery(name = "findByBrandName",
	query="SELECT ic FROM IceCream ic WHERE LOWER(ic.brand.name) = LOWER(:brand)")
})
public class IceCream {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ice_cream_id")
	private int iceCreamId;

	private String name;
	
	// I don't recommend putting cascing on unless you can explain why
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	@ManyToMany
	@JoinTable(
			name="ice_cream_flavor",
			joinColumns=@JoinColumn(name="ice_cream_id"),
			inverseJoinColumns=@JoinColumn(name="flavor_id")
	)
	private List<Flavor> flavors;
	
	@ManyToMany
	@JoinTable(
			name="ice_cream_topping",
			joinColumns=@JoinColumn(name="ice_cream_id"),
			inverseJoinColumns=@JoinColumn(name="topping_id")
	)
	private List<Topping> toppings;

	public IceCream() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IceCream(int iceCreamId, String name, Brand brand, List<Flavor> flavors, List<Topping> toppings) {
		super();
		this.iceCreamId = iceCreamId;
		this.name = name;
		this.brand = brand;
		this.flavors = flavors;
		this.toppings = toppings;
	}

	public int getIceCreamId() {
		return iceCreamId;
	}

	public void setIceCreamId(int iceCreamId) {
		this.iceCreamId = iceCreamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<Flavor> getFlavors() {
		return flavors;
	}

	public void setFlavors(List<Flavor> flavors) {
		this.flavors = flavors;
	}

	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((flavors == null) ? 0 : flavors.hashCode());
		result = prime * result + iceCreamId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((toppings == null) ? 0 : toppings.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IceCream other = (IceCream) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (flavors == null) {
			if (other.flavors != null)
				return false;
		} else if (!flavors.equals(other.flavors))
			return false;
		if (iceCreamId != other.iceCreamId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (toppings == null) {
			if (other.toppings != null)
				return false;
		} else if (!toppings.equals(other.toppings))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "IceCream [iceCreamId=" + iceCreamId + ", name=" + name + ", brand=" + brand + ", flavors=" + flavors
				+ ", toppings=" + toppings + "]";
	}
	
	
}

package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private int brandId;

	private String name;

	@OneToMany(mappedBy = "brand")
	private List<IceCream> iceCream;

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Brand(int brandId, String name, List<IceCream> iceCream) {
		super();
		this.brandId = brandId;
		this.name = name;
		this.iceCream = iceCream;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<IceCream> getIceCream() {
		return iceCream;
	}

	public void setIceCream(List<IceCream> iceCream) {
		this.iceCream = iceCream;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brandId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Brand other = (Brand) obj;
		if (brandId != other.brandId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", name=" + name + "]";
	}

}

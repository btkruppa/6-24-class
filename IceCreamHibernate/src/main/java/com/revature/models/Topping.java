package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topping {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "topping_id")
	private int toppingId;

	private String name;

	public Topping() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Topping(int toppingId, String name) {
		super();
		this.toppingId = toppingId;
		this.name = name;
	}

	public int getToppingId() {
		return toppingId;
	}

	public void setToppingId(int toppingId) {
		this.toppingId = toppingId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + toppingId;
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
		Topping other = (Topping) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (toppingId != other.toppingId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Topping [toppingId=" + toppingId + ", name=" + name + "]";
	}

}

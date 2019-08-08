package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flavor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flavor_id")
	private int flavorId;

	private String name;

	public Flavor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flavor(int flavorId, String name) {
		super();
		this.flavorId = flavorId;
		this.name = name;
	}

	public int getFlavorId() {
		return flavorId;
	}

	public void setFlavorId(int flavorId) {
		this.flavorId = flavorId;
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
		result = prime * result + flavorId;
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
		Flavor other = (Flavor) obj;
		if (flavorId != other.flavorId)
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
		return "Flavor [flavorId=" + flavorId + ", name=" + name + "]";
	}

}

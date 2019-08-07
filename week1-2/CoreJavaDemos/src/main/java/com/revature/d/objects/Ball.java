package com.revature.d.objects;

public class Ball implements Comparable<Ball>{
	private String color;
	private double weight;
	private String material;
	private double radius;

	public Ball() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ball(String color, double weight, String material, double radius) {
		super();
		this.color = color;
		this.weight = weight;
		this.material = material;
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if (radius < 0) {
			return;
		} else {
			this.radius = radius;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((material == null) ? 0 : material.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(weight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Ball other = (Ball) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (material == null) {
			if (other.material != null)
				return false;
		} else if (!material.equals(other.material))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		if (Double.doubleToLongBits(weight) != Double.doubleToLongBits(other.weight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ball [color=" + color + ", weight=" + weight + ", material=" + material + ", radius=" + radius + "]";
	}

	@Override
	public int compareTo(Ball o) {
		double compared = o.getRadius() - this.getRadius();
		if(compared == 0) {
			double weightCompared = o.getWeight() - this.getWeight();
			return (int) Math.copySign(1, weightCompared);
		} else {
			int radiusCompare = (int) Math.copySign(1, compared);
			return radiusCompare;
		}
	}

}

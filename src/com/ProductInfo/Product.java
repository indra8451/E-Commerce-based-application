package com.ProductInfo;

public class Product {
	
	
	private int pid;
	private String Description;
	private String Name;
	private int Price;
	private int Quantity;
	
	public Product(int pid, String description, String name, int price, int quantity) {
		this.pid = pid;
		Description = description;
		Name = name;
		Price = price;
		Quantity = quantity;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", Description=" + Description + ", Name=" + Name + ", Price=" + Price
				+ ", Quantity=" + Quantity + "]";
	}
	
	

}

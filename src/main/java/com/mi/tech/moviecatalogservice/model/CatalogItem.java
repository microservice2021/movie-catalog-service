package com.mi.tech.moviecatalogservice.model;

public class CatalogItem {
	
	private String name;
	private String discription;
	private int rating;
	
	public CatalogItem(String name, String discription, int rating) {
		this.name = name;
		this.discription = discription;
		this.rating = rating;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	

}

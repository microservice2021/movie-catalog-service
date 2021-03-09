package com.mi.tech.moviecatalogservice.model;

public class Movie {
	
	private String movieId;
	private String name;
	private String discription;
	
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movie(String movieId, String name, String discription) {
		super();
		this.movieId = movieId;
		this.name = name;
		this.discription = discription;
	}
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
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
	
	
	
	
	
	

}

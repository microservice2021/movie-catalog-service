package com.mi.tech.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.mi.tech.moviecatalogservice.model.CatalogItem;
import com.mi.tech.moviecatalogservice.model.Movie;
import com.mi.tech.moviecatalogservice.model.Rating;
import com.mi.tech.moviecatalogservice.model.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webClient;
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getMovieCatalogByUserId(@PathVariable ("userId") String userId){
		//RestTemplate restTemplate=new RestTemplate();
	      

            /* List<Rating> ratings=Arrays.asList(
				new Rating("111", 4),
				new Rating("112", 2),
				new Rating("113", 3),
				new Rating("114", 5)
				
				);*/
		
		UserRating ratings=restTemplate.getForObject("http://rating-data-service/rating/users/" + userId, UserRating.class);  
		   return ratings.getUserRatings().stream().map(rating -> {
			Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			  // Movie movie=webClient.build()
			  // .get()
			  // .uri("http://localhost:8082/movies/"+rating.getMovieId())
			   //.retrieve()
			   //.bodyToMono(Movie.class)
			   //.block();
			return new CatalogItem(movie.getName(), movie.getDiscription(), rating.getRating());
			
		
		}).collect(Collectors.toList());
		
	//return Collections.singletonList(new CatalogItem("Dil", "amir khan flim", 4));
	}

}

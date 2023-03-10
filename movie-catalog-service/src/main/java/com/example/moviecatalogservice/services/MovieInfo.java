package com.example.moviecatalogservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Ratings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfo {
	 @Autowired
	 private RestTemplate restTemplate;

	
	@HystrixCommand(fallbackMethod = "getFallBackCatalogItem")
	public CatalogItem getCatalogItem(Ratings rating) {
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(movie.getName(), "test", rating.getRating());
	}
	
	 public  CatalogItem  getFallBackCatalogItem(Ratings rating) {		
			return new CatalogItem("Movie name not found", "", rating.getRating());

		}
}
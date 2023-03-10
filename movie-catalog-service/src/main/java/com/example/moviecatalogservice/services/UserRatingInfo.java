package com.example.moviecatalogservice.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.moviecatalogservice.models.Ratings;
import com.example.moviecatalogservice.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserRatingInfo {

	 @Autowired
	 private RestTemplate restTemplate;

	
	@HystrixCommand(fallbackMethod = "getFallBackUserRating")
	public UserRating getUserRating(String userId) {
		return restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+userId, UserRating.class);
	}
	public UserRating getFallBackUserRating(String userId) {
		UserRating userRating=new UserRating();
		userRating.setUserId(userId);
		userRating.setUserRating(Arrays.asList(new Ratings("0",0)));	
			return userRating;
	}	
}
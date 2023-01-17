package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Ratings;
import com.example.moviecatalogservice.models.UserRating;
import com.example.moviecatalogservice.services.MovieInfo;
import com.example.moviecatalogservice.services.UserRatingInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    MovieInfo movieInfo;
    
    @Autowired
    UserRatingInfo userRatingInfo;
     
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {
    	
    	
//         List<Ratings> ratings = Arrays.asList(
//                new Ratings("1", 4),
//                new Ratings("2", 5)
//        );

         UserRating ratings = userRatingInfo.getUserRating(userId);

         
          return ratings.getUserRating().stream().map(rating -> {
            return movieInfo.getCatalogItem(rating);
        })
                .collect(Collectors.toList());
    }

	/*
	 * @HystrixCommand(fallbackMethod = "getFallBackCatalogItem") private
	 * CatalogItem getCatalogItem(Ratings rating) { Movie movie =
	 * restTemplate.getForObject("http://movie-info-service/movies/" +
	 * rating.getMovieId(), Movie.class); return new CatalogItem(movie.getName(),
	 * "test", rating.getRating()); }
	 * 
	 * @HystrixCommand(fallbackMethod = "getFallBackUserRating") private UserRating
	 * getUserRating(String userId) { return
	 * restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/"+
	 * userId, UserRating.class); }
	 * 
	 * public CatalogItem getFallBackCatalogItem(Ratings rating) { return new
	 * CatalogItem("Movie name not found", "", rating.getRating());
	 * 
	 * } private UserRating getFallBackUserRating(String userId) { UserRating
	 * userRating=new UserRating(); userRating.setUserId(userId);
	 * userRating.setUserRating(Arrays.asList(new Ratings("0",0))); return
	 * userRating; }
	 */
    
    
    
    public List<CatalogItem> getFallBackMethod(@PathVariable String userId) {
    	
    	return Arrays.asList( new CatalogItem("No movie", "", 0));
    	
    }
}
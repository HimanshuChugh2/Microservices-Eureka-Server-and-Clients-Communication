package com.example.ratingdataservice.resources;

import com.example.ratingdataservice.models.Ratings;
import com.example.ratingdataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingDataService {
    @RequestMapping("/{movieId}")
    public Ratings ratings(@PathVariable String movieId)
    {
        return new Ratings("1",4);
    }

    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId)
    {
        // the below list is hard coded data. That should come from DB.
        List<Ratings> ratings = Arrays.asList(
                new Ratings("550", 1),
                new Ratings("3",3)
        );
        //Populating the userRating object to return on API call.
        //dont return list directly, return an object(explained in 15th video
        UserRating userRating=new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
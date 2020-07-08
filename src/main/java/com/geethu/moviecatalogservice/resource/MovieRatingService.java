package com.geethu.moviecatalogservice.resource;

import com.geethu.moviecatalogservice.model.MovieRating;
import com.geethu.moviecatalogservice.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
public class MovieRatingService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @HystrixCommand(fallbackMethod = "getFallbackRatings")
    public UserRating getRatings(@PathVariable String userId) {
        return webClientBuilder.build()
                .get()
                .uri("http://movie-ratings-data-service:8082/ratings/users/550"+ userId)
                .retrieve()
                .bodyToMono(UserRating.class)
                .block();
    }
    public UserRating getFallbackRatings(@PathVariable String userId){
        UserRating rating = new UserRating();
        rating.setUserRatings(Arrays.asList(new MovieRating("",0,"")));
        return rating;
    }
}

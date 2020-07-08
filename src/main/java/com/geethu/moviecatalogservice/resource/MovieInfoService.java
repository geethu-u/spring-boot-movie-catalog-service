package com.geethu.moviecatalogservice.resource;

import com.geethu.moviecatalogservice.model.CatalogItem;
import com.geethu.moviecatalogservice.model.Movie;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MovieInfoService {

    @Autowired
    private WebClient.Builder webClientBuilder;

    //coresize, maxQueueSize for bulkhead pattern, use only from this threadpool
    @HystrixCommand(
            fallbackMethod = "getFallbackCatalog",
            threadPoolKey = "movieInfoPool",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="20"),
                    @HystrixProperty(name="maxQueueSize", value="10")
            }
            )
    public CatalogItem getCatalogItem(String movieId, int rating) {
        //BodtToMOno - Mono is something that comes back in the future
        Movie movie = webClientBuilder.build()
                .get()
                .uri("http://movie-info-service:8081/movies/"+ movieId)
                .retrieve()
                .bodyToMono(Movie.class)
                .block();
        return new CatalogItem(movie.getMovieId(), movie.getMovieName(), movie.getMovieDesc(), rating);
    }

    public CatalogItem getFallbackCatalog(String movieId, int rating) {
        return new CatalogItem("Movie name not found", "", "", rating);

    }
}

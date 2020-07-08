package com.geethu.moviecatalogservice.resource;

import com.geethu.moviecatalogservice.model.CatalogItem;
import com.geethu.moviecatalogservice.model.UserRating;
import com.geethu.moviecatalogservice.settings.DBSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Value("${my.greeting}")
    String myGreeting;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MovieInfoService movieInfoService;

    @Autowired
    private  MovieRatingService movieRatingService;

    @Autowired
    private DBSettings dbSettings;

    @Autowired
    private Environment environment;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){
        System.out.println("Config fetched from all db. prefixes into DB settings bean: "+ dbSettings.getHost()+dbSettings.getPort());
        System.out.println("Config fetched from Config server:, comment out active profile test "+ myGreeting);

        UserRating ratings = movieRatingService.getRatings(userId);

        return ratings.getUserRatings().stream().map(r->{
//            Movie movie = restTemplate.getForObject("http://localhost:8081/movies/"+ r.getMovieId(), Movie.class);
            return movieInfoService.getCatalogItem(r.getMovieId(), r.getRatingStars());
        }).collect(Collectors.toList());
    }
    @RequestMapping("/envDetails")
    public String getEnvDetails() {
        return environment.toString();
    }

    }

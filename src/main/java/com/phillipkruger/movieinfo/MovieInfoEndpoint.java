package com.phillipkruger.movieinfo;

import com.phillipkruger.movieinfo.model.Genre;
import com.phillipkruger.movieinfo.model.Movie;
import com.phillipkruger.movieinfo.service.MovieService;
import io.smallrye.common.annotation.NonBlocking;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.validation.constraints.Min;
import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
@NonBlocking
public class MovieInfoEndpoint {

    @Inject
    MovieService movieService;
    
    @Query
    public List<Movie> getAllMovies(){
        return addThreadName(movieService.getAllMovies());
    }
    
    @Query
    public List<Movie> searchByTitle(String term) throws InterruptedException{
        return addThreadName(movieService.searchTitle(term));
    }
    
    public List<Movie> sameGenreMovies(@Source Movie movie, @Min(0) @DefaultValue("0") int limit) throws InterruptedException{
        List<Movie> sameGenreMovies = movieService.getMovies(movie.getGenres().toArray(new Genre[]{}));
        sameGenreMovies.remove(movie);
        if(limit>0){
            sameGenreMovies = sameGenreMovies.subList(0, limit);
        }
        return addThreadName(sameGenreMovies);
    }
    
    private List<Movie> addThreadName(List<Movie> movies){
        return movies.stream()
                .map(this::addThreadName)
                .collect(Collectors.toList());
    }
    
    private Movie addThreadName(Movie movie){
        Thread t = Thread.currentThread();
        movie.setThreadName(t.getName());
        return movie;
    }
}

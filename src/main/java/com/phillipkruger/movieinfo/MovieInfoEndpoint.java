package com.phillipkruger.movieinfo;

import com.phillipkruger.movieinfo.model.Genre;
import com.phillipkruger.movieinfo.model.Movie;
import com.phillipkruger.movieinfo.service.MovieService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class MovieInfoEndpoint {

    @Inject
    MovieService movieService;
    
    @Query
    public Uni<List<Movie>> getAllMovies(){
        return Uni.createFrom().item(() -> addThreadName(movieService.getAllMovies()));
    }
    
    @Query
    public Uni<List<Movie>> searchByTitle(String term) throws InterruptedException{
        return Uni.createFrom().item(() -> addThreadName(movieService.searchTitle(term)));
    }
    
    @Blocking
    public List<Movie> otherMoviesByActor(@Source Movie movie) throws InterruptedException{
        List<Movie> otherMoviesByActor = movieService.getMovies(movie.getCast().get(0).getActor());
        return addThreadName(otherMoviesByActor);
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

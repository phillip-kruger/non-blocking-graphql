package com.phillipkruger.movieinfo;

import com.phillipkruger.movieinfo.model.Movie;
import com.phillipkruger.movieinfo.service.MovieService;
import io.smallrye.mutiny.Uni;
import java.util.List;
import java.util.concurrent.CompletableFuture;
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
    public List<Movie> getAllMovies(){
        return addThreadName(movieService.getAllMovies());
    }
    
    @Query
    public Uni<List<Movie>> searchByTitle(String term) {
        return Uni.createFrom().item(() -> addThreadName(movieService.searchTitle(term)));
    }
    
    public List<Movie> otherMoviesByActor(@Source Movie movie) throws InterruptedException{
        List<Movie> otherMoviesByActor = movieService.getMovies(movie.getCast().get(0).getActor());
        otherMoviesByActor.remove(movie);
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

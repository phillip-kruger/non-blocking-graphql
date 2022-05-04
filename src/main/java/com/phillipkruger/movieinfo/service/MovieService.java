package com.phillipkruger.movieinfo.service;

import com.phillipkruger.movieinfo.model.CastMember;
import com.phillipkruger.movieinfo.model.Genre;
import com.phillipkruger.movieinfo.model.Movie;
import com.phillipkruger.movieinfo.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieService {

    public List<Movie> searchTitle(String term){
        List<Movie> moviesBySearchTerm = new ArrayList<>();
        for(Movie m:MOVIES){
            if(m.getTitle().toLowerCase().contains(term.toLowerCase())){
               moviesBySearchTerm.add(m);
            }
        }
        return moviesBySearchTerm;
    }
    
    public List<Movie> getAllMovies(){
        return MOVIES;
    }
    
    public List<Movie> getMovies(Genre... genres){
        List<Movie> moviesByGenre = new ArrayList<>();
        for(Movie movie:MOVIES){
            for(Genre genre:genres){
                if(movie.getGenres().contains(genre) && !moviesByGenre.contains(movie)){
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
    }
    
    private static final List<Movie> MOVIES = new ArrayList<>();
    
    private static final Person FRANK_DARABONT = new Person("Darabont", "Frank");
    private static final Person STEPHEN_KING = new Person("King", "Stephen");
    private static final Person TIM_ROBBINS = new Person("Robbins", "Tim");
    private static final Person MORGAN_FREEMAN = new Person("Freeman", "Morgan");
    private static final Person BOB_GUNTON = new Person("Gunton", "Bob");
    private static final Person ANDY_DUFRESNE = new Person("Dufresne", "Andy");
    private static final Person ELLIS_REDDING = new Person("Redding", "Ellis", "Boyd");
    private static final Person WARDEN_NORTON = new Person("Norton", "Warden");
    private static final Person FRANCIS_CAPPOLA = new Person("Coppola", "Francis", "Ford");
    private static final Person MARIO_PUZU = new Person("Puzo", "Mario");
    private static final Person MARLON_BRANDO = new Person("Brando", "Marlon");
    private static final Person AL_PACINO = new Person("Pacino", "Al");
    private static final Person JAMES_CAAN = new Person("Caan", "James");
    private static final Person DIANE_KEATON = new Person("Keaton", "Diane");
    private static final Person DON_CORLEONE = new Person("Corleone", "Don", "Vito");
    private static final Person MICHAEL = new Person("", "Michael");
    private static final Person SONNY = new Person("", "Sonny");
    private static final Person KAY_ADAMS = new Person("Adams", "Kay");
    private static final Person CHRISTOPHER_NOLAN = new Person("Nolan", "Christopher");
    private static final Person JONATHAN_NOLAN = new Person("Nolan", "Jonathan");
    private static final Person DAVID_S_GOYER = new Person("Goyer", "David", "S");
    private static final Person CHRISTIAN_BALE = new Person("Bale", "Christian");
    private static final Person HEATH_LEDGER = new Person("Ledger", "Heath");
    private static final Person AARON_ECKHART = new Person("Eckhart", "Aaron");
    private static final Person BRUCE_WAYNE = new Person("Wayne", "Bruce");
    private static final Person JOKER = new Person("","Joker");
    private static final Person HARVEY_DENT = new Person("Dent","Harvey");

    private static final Movie SHAWSHANK_REDEMPTION = new Movie("The Shawshank Redemption", 
                        1994, 
                        List.of(Genre.Drama), 
                        9.3, 
                        "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.", 
                        List.of(FRANK_DARABONT), 
                        List.of(STEPHEN_KING, FRANK_DARABONT), 
                        List.of(new CastMember(TIM_ROBBINS,ANDY_DUFRESNE), 
                                new CastMember(MORGAN_FREEMAN,ELLIS_REDDING),
                                new CastMember(BOB_GUNTON,WARDEN_NORTON)));

    private static final Movie GODFATHER = new Movie("The Godfather", 
                        1972, 
                        List.of(Genre.Crime,Genre.Drama), 
                        9.2, 
                        "The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.", 
                        List.of(FRANCIS_CAPPOLA), 
                        List.of(FRANCIS_CAPPOLA, MARIO_PUZU),
                        List.of(new CastMember(MARLON_BRANDO,DON_CORLEONE), 
                                new CastMember(AL_PACINO,MICHAEL),
                                new CastMember(JAMES_CAAN,SONNY),
                                new CastMember(DIANE_KEATON,KAY_ADAMS)));
    
                
    
    private static final Movie DARK_KNIGHT = new Movie("The Dark Knight", 
                        2008, 
                        List.of(Genre.Crime,Genre.Drama, Genre.Action), 
                        9.0, 
                        "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.", 
                        List.of(CHRISTOPHER_NOLAN), 
                        List.of(JONATHAN_NOLAN, CHRISTOPHER_NOLAN, DAVID_S_GOYER), 
                        List.of(new CastMember(CHRISTIAN_BALE,BRUCE_WAYNE), 
                                new CastMember(HEATH_LEDGER,JOKER),
                                new CastMember(AARON_ECKHART,HARVEY_DENT)));
    
    
    
    static {
        MOVIES.add(SHAWSHANK_REDEMPTION);
        MOVIES.add(GODFATHER);
        MOVIES.add(DARK_KNIGHT);
    }
    
}

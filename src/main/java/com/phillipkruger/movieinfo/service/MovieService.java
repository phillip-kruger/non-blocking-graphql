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
    
    public List<Movie> getMovies(Person actor){
        List<Movie> moviesByActor = new ArrayList<>();
        for(Movie movie:MOVIES){
            List<CastMember> cast = movie.getCast();
            for(CastMember castMember:cast){
                if(castMember.getActor().equals(actor)){
                    moviesByActor.add(movie);
                }
            }
        }
        return moviesByActor;
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
    private static final Person MARY_HARRON = new Person("Harron", "Mary");
    private static final Person BRET_EASTON_ELLIS = new Person("Ellis", "Bret", "Easton");
    private static final Person GUINEVERE_TURNER = new Person("Turner", "Guinevere");
    private static final Person PATRICK_BATEMAN = new Person("Bateman", "Patrick");
    private static final Person JUSTIN_THEROUX = new Person("Theroux", "Justin");
    private static final Person TIMOTHY_BRYCE = new Person("Bryce", "Timothy");
    private static final Person BOB_KANE = new Person("Kane", "Bob");
    private static final Person LIAM_NEESON = new Person("Neeson", "Liam");
    private static final Person MICHAEL_CANE = new Person("Cane", "Michael");
    private static final Person ALFRED = new Person("", "Alfred");
    private static final Person DUCARD = new Person("", "Ducard");
    private static final Person PIERRE_MOREL = new Person("Morel", "Pierre");
    private static final Person LUC_BESSON = new Person("Besson", "Luc");
    private static final Person ROBERT_MARK_KAMEN = new Person("Kamen", "Robert", "Mark");
    private static final Person BRYAN_MILLS = new Person("Mills", "Bryan");
    private static final Person MAGGIE_GRACE = new Person("Grace", "Maggie");
    private static final Person KIM = new Person("", "Kim");
    private static final Person FAMKE_JANSSEN = new Person("Janssen", "Famke");
    private static final Person LENORE = new Person("", "Lenore");
            
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
    
    private static final Movie AMERICAN_PSYCHO = new Movie("American Psycho", 
                        2000, 
                        List.of(Genre.Crime,Genre.Drama, Genre.Horror), 
                        7.6, 
                        "A wealthy New York City investment banking executive, Patrick Bateman, hides his alternate psychopathic ego from his co-workers and friends as he delves deeper into his violent, hedonistic fantasies.", 
                        List.of(MARY_HARRON), 
                        List.of(BRET_EASTON_ELLIS, MARY_HARRON, GUINEVERE_TURNER), 
                        List.of(new CastMember(CHRISTIAN_BALE,PATRICK_BATEMAN), 
                                new CastMember(HEATH_LEDGER,JOKER),
                                new CastMember(JUSTIN_THEROUX,TIMOTHY_BRYCE)));
    
    private static final Movie BATMAN_BEGINS = new Movie("Batman Begins", 
                        2005, 
                        List.of(Genre.Crime,Genre.Drama, Genre.Action),
                        8.2, 
                        "After training with his mentor, Batman begins his fight to free crime-ridden Gotham City from corruption.", 
                        List.of(CHRISTOPHER_NOLAN), 
                        List.of(CHRISTOPHER_NOLAN, DAVID_S_GOYER, BOB_KANE), 
                        List.of(new CastMember(CHRISTIAN_BALE,BRUCE_WAYNE), 
                                new CastMember(MICHAEL_CANE,ALFRED),
                                new CastMember(LIAM_NEESON,DUCARD)));
    
    private static final Movie TAKEN = new Movie("Taken", 
                        2008, 
                        List.of(Genre.Thriller,Genre.Drama, Genre.Action),
                        7.8, 
                        "A retired CIA agent travels across Europe and relies on his old skills to save his estranged daughter, who has been kidnapped while on a trip to Paris.",
                        List.of(PIERRE_MOREL), 
                        List.of(LUC_BESSON, ROBERT_MARK_KAMEN), 
                        List.of(new CastMember(LIAM_NEESON,BRYAN_MILLS), 
                                new CastMember(MAGGIE_GRACE,KIM),
                                new CastMember(FAMKE_JANSSEN,LENORE)));
    
    static {
        MOVIES.add(SHAWSHANK_REDEMPTION);
        MOVIES.add(GODFATHER);
        MOVIES.add(DARK_KNIGHT);
        MOVIES.add(AMERICAN_PSYCHO);
        MOVIES.add(BATMAN_BEGINS);
        MOVIES.add(TAKEN);
    }
    
}

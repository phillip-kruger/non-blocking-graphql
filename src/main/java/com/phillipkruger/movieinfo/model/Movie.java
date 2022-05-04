package com.phillipkruger.movieinfo.model;

import java.util.List;
import java.util.Objects;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Movie {
    private String title;
    private int releaseYear;
    private List<Genre> genres;
    @Min(0) @Max(10)
    private Double rating;
    private String description;
    private List<Person> directors;
    private List<Person> writers;
    private List<CastMember> cast;
    private String threadName;
    
    public Movie() {
    }

    public Movie(String title, int releaseYear, List<Genre> genres, Double rating, String description, List<Person> directors, List<Person> writers, List<CastMember> cast) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.rating = rating;
        this.description = description;
        this.directors = directors;
        this.writers = writers;
        this.cast = cast;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public List<Person> getWriters() {
        return writers;
    }

    public void setWriters(List<Person> writers) {
        this.writers = writers;
    }

    public List<CastMember> getCast() {
        return cast;
    }

    public void setCast(List<CastMember> cast) {
        this.cast = cast;
    }

    public String getThreadName(){
        return threadName;
    }
    
    public void setThreadName(String threadName){
        this.threadName = threadName;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.title);
        hash = 59 * hash + this.releaseYear;
        hash = 59 * hash + Objects.hashCode(this.genres);
        hash = 59 * hash + Objects.hashCode(this.directors);
        hash = 59 * hash + Objects.hashCode(this.writers);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.releaseYear != other.releaseYear) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.genres, other.genres)) {
            return false;
        }
        if (!Objects.equals(this.directors, other.directors)) {
            return false;
        }
        return Objects.equals(this.writers, other.writers);
    }
    
    
}

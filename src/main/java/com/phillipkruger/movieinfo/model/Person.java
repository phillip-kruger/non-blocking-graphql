package com.phillipkruger.movieinfo.model;

import java.util.Arrays;
import java.util.Objects;

public class Person {
    private String[] names;
    private String surname;

    public Person() {
    }

    public Person(String surname, String... names) {
        this.names = names;
        this.surname = surname;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Arrays.deepHashCode(this.names);
        hash = 97 * hash + Objects.hashCode(this.surname);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        return Arrays.deepEquals(this.names, other.names);
    }
    
}

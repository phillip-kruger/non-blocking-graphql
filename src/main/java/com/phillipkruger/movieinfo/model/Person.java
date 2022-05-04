package com.phillipkruger.movieinfo.model;

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
}

package com.phillipkruger.movieinfo.model;

public class CastMember {
    private Person actor;
    private Person portrayed;

    public CastMember() {
    }

    public CastMember(Person actor, Person portrayed) {
        this.actor = actor;
        this.portrayed = portrayed;
    }

    public Person getActor() {
        return actor;
    }

    public void setActor(Person actor) {
        this.actor = actor;
    }

    public Person getPortrayed() {
        return portrayed;
    }

    public void setPortrayed(Person portrayed) {
        this.portrayed = portrayed;
    }
}

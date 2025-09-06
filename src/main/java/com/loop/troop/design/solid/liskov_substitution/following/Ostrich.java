package com.loop.troop.design.solid.liskov_substitution.following;

// No fly() method since it cannot fly
public class Ostrich extends Bird {
    public Ostrich(String name) {
        super(name);
    }
}
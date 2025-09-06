package com.loop.troop.design.solid.liskov_substitution.not_following;

public class Ostrich extends Bird {

    public Ostrich(String name) {
        super(name);
    }

    @Override
    public void fly() {
        // Ostriches cannot fly, but the base class says fly() should work
        throw new UnsupportedOperationException(getName() + " cannot fly!");
    }
}
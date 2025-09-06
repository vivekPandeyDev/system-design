package com.loop.troop.design.solid.liskov_substitution.not_following;

public class LSPDemo {

    public static void makeBirdFly(Bird bird) {
        bird.fly();  // Assumes all birds can fly
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow("Jack");
        makeBirdFly(sparrow);  // Works fine

        Bird ostrich = new Ostrich("Olivia");
        makeBirdFly(ostrich);  // Violates LSP: throws exception
    }
}
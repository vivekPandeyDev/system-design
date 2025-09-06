package com.loop.troop.design.solid.liskov_substitution.following;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class LSPDemo {

    public static void makeFly(Flyable bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Flyable sparrow = new Sparrow("Jack");
        makeFly(sparrow);  // Works fine

        // Ostrich does not implement Flyable, so cannot be passed here
        Bird ostrich = new Ostrich("Olivia");
        log.info("{} cannot fly.",ostrich.getName() );
    }
}
package com.loop.troop.design.solid.liskov_substitution.not_following;


import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Getter
@Log4j2
public class Bird {
    private final String name;

    public Bird(String name) {
        this.name = name;
    }
    // All birds are expected to fly
    public void fly() {
        log.info("{} is flying.",name );
    }
}
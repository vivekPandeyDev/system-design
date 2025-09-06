package com.loop.troop.design.solid.liskov_substitution.following;


import lombok.extern.log4j.Log4j2;

@Log4j2
public class Sparrow extends Bird implements Flyable {

    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        log.info("{} is flying.",getName());
    }
}
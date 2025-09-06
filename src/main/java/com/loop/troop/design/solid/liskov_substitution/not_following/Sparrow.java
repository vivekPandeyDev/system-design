package com.loop.troop.design.solid.liskov_substitution.not_following;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Sparrow extends Bird {

    public Sparrow(String name) {
        super(name);
    }

    @Override
    public void fly() {
        log.info( "{} is flying happily.",getName());
    }
}
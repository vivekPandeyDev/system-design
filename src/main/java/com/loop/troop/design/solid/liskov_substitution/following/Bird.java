package com.loop.troop.design.solid.liskov_substitution.following;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Bird {
    private final String name;
}
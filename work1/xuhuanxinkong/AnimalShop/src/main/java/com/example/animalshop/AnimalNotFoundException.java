package com.example.animalshop;

public class AnimalNotFoundException extends RuntimeException {
    public AnimalNotFoundException(String message) {
        super(message);
    }
}


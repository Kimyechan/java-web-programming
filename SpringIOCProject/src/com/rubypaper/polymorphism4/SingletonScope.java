package com.rubypaper.polymorphism4;

public class SingletonScope {
    private static SingletonScope instance;

    private SingletonScope() {

    }

    public SingletonScope getInstance() {
        if(instance == null) {
            instance = new SingletonScope();
        }
        return instance;
    }
}

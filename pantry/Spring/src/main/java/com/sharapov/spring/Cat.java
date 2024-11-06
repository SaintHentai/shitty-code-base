package com.sharapov.spring;

import org.springframework.stereotype.Component;


public class Cat implements Pet{

    public Cat(){
        System.out.println("Cat bean is created");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}

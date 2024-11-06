package com.sharapov.spring;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet{

    public Dog(){
        System.out.println("Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-bow");
    }
}

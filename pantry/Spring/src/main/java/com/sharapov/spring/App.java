package com.sharapov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        /*Person person = context.getBean("personBean", Person.class);
        person.callPet();*/
        /*ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);*/

        Person person = context.getBean(Person.class);
        person.callPet();

        context.close();
    }

}

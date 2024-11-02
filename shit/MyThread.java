package com.company;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyThread {

    static class HelloThread extends Thread {
        public void run() {
            int i = 0;
            try {
                do {
                    i++;
                    if (!isInterrupted()) {//isInterrupted проверять в любых ключевых точках,
                        // где можно обработать прерывание потока
                        if(i%5==1) System.out.println("Hello from a thread! " + i);
                    } else {
                        throw new InterruptedException(); //бросаем исключение в таких случаях как этот (циклы)
                    }
                }while (true);
            } catch (InterruptedException e) {
                System.out.println("Thread is interrupted"); //Закрываем все стримы если есть
            }

            //Не забывайте, что поток завершается когда нечего испонять
            System.out.println("Nothing to say"); //и окончательно он завершится после этой строки
        }
    }

    public static void main(String[] args) {
        final HelloThread helloThread = new HelloThread(); //final - для таймера
        helloThread.start();

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Interrupting thread...");
                helloThread.interrupt();
            }
        });
        timer.setRepeats(false);
        timer.start();
        System.out.println("Thread main still work");
    }
}


package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame implements WindowListener{

    public Main(){
        super("A Frame");
        setSize(400, 400);
        //in case the user closes the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        //enables Window Events on this Component
        this.addWindowListener(this);

        //start a timer
        Thread t = new Timer();
        t.start();
    }

    public void windowOpened(WindowEvent e){}
    public void windowClosing(WindowEvent e){}

    //the event that we are interested in
    public void windowClosed(WindowEvent e){
        try {
            Desktop.getDesktop().open(new File("C:\\Users\\Admin\\Desktop\\test\\TestB.jar"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.exit(0);
    }

    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}

    //a simple timer
    class Timer extends Thread{
        int time = 20;
        public void run(){
            while(time-- > 0){
                System.out.println("Still Waiting:" + time);
                try{
                    sleep(1000);
                }catch(InterruptedException e){}
            }
            System.out.println("About to close");
            //close the frame
            Main.this.processWindowEvent(
                    new WindowEvent(
                            Main.this, WindowEvent.WINDOW_CLOSED));
        }
    }

    //instantiate the Frame
    public static void main(String args[]) throws Exception {
        new Main();
    }

}

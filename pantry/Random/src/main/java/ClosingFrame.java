import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.*;

public class ClosingFrame extends JFrame implements WindowListener{

    public ClosingFrame(){
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
        System.exit(0);
    }

    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}

    //a simple timer
    class Timer extends Thread{
        int time = 1;
        public void run(){
            while(time-- > 0){
                System.out.println("Still Waiting:" + time);
                try{
                    TimeUnit.MINUTES.sleep(1);
                }catch(InterruptedException e){}
            }
            System.out.println("About to close");
            //close the frame
            ClosingFrame.this.processWindowEvent(
                    new WindowEvent(
                            ClosingFrame.this, WindowEvent.WINDOW_CLOSED));
        }
    }

    //instantiate the Frame
    public static void main(String args[]){
        new ClosingFrame();
    }

}

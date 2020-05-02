package pjc.unit4;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by joao_lourenco on 8/17/17.
 */
public class Worker extends Thread {

    private Object lock =  new Object();
    private volatile boolean quitingTime = false;

    @Override
    public void run() {
        while (!quitingTime){
            working();
            System.out.println("Still working...");
        }
        System.out.println("Coffee is good!");
    }

    private void working(){
        try {
            Thread.sleep(300);
        }catch (InterruptedException ex){

        }
    }

    void quit() throws InterruptedException {
       synchronized (lock) {
           quitingTime = true;
           System.out.println("Calling join");
           join();
           System.out.println("Back from join");
       }
    }

    void keepWorking(){
        synchronized (lock) {
            quitingTime = false;
            System.out.println("Keep Working");
        }
    }


    public static void main(String... args) throws InterruptedException {

        final Worker worker = new Worker();
        worker.start();


        Timer t = new Timer(true); //Deamon thread
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        }, 500  );

        Thread.sleep(400);
        worker.quit();
    }

}

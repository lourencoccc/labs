package pjc.unit1;

/**
 * Created by joao_lourenco on 8/8/17.
 */
public class FirstRunnable {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am runing in " + Thread.currentThread().getName());
        };

        Thread t = new Thread(runnable);
        t.setName("My thread");

        t.start(); //start a new thread
//        t.run(); //Don't use for to start new thread. this only call runnnable methodo run
    }
}

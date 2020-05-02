package pjc.unit1;

/**
 * Created by joao_lourenco on 8/9/17.
 */
public class DeadLockMain {

    public static void main(String[] args) throws InterruptedException {
        DeadLockA deadLockA = new DeadLockA();
        Runnable r1 = () -> deadLockA.a();
        Runnable r2 = () -> deadLockA.b();

        Thread t1 = new Thread(r1);
        t1.start();

        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}

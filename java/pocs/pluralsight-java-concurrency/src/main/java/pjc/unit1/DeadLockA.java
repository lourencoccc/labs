package pjc.unit1;

/**
 * Created by joao_lourenco on 8/9/17.
 */
public class DeadLockA {

    private Object key1 = new Object();
    private Object key2 = new Object();

    public void a() {
        synchronized (key1) {
            for(int i = 0; i < 1_000; i++){}
            System.out.println("["+ Thread.currentThread().getName() +"] I am in a()");
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            for(int i = 0; i < 1_000; i++){}
            System.out.println("["+ Thread.currentThread().getName() +"] I am in b()");
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            System.out.println("["+ Thread.currentThread().getName() +"] I am in c()");
        }
    }
}

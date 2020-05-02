package pjc.unit1;

/**
 * Created by joao_lourenco on 8/8/17.
 */
public class RaceCondition {

    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper =  new LongWrapper(0L);
        Runnable r = () -> {
//            System.out.println("Thread "
//                    + Thread.currentThread().getName()
//                    + "value l = " + longWrapper.getValue()
//            );
            for (int i = 0; i < 1_000_000; i++){
                longWrapper.incrementValue();
            }
        };
//
//        Thread t =  new Thread(r);
//        t.start();
//        t.join(); //Waits for this thread to die.

        Thread[] threads =  new Thread[1_1243];
        for(int i=0; i < threads.length; i++){
            threads[i] = new Thread(r);
            threads[i].setName("T"+i);
            threads[i].start();
        }

        for(int i=0; i < threads.length; i++){
            threads[i].join();
        }

        System.out.println("Values = " + longWrapper.getValue());
    }

}

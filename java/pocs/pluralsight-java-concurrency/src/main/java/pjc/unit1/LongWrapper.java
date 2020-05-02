package pjc.unit1;

/**
 * Created by joao_lourenco on 8/8/17.
 */
public class LongWrapper {

//    private Object key = new Object();
    private long l;

    public LongWrapper(long l){
        this.l = l;
    }

    public long getValue(){
        return l;
    }

//    public void incrementValue() {
//        //race condition problem
//        this.l = this.l + 1;
//    }

//    public void incrementValue(){
//        //race condition solution 1
//        synchronized (key) {
//            this.l = this.l + 1;
//        }
//    }

    public synchronized void  incrementValue(){
        //race condition solution 2
        this.l = this.l + 1;
    }

}

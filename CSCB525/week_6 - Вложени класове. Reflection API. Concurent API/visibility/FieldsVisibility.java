package visibility;

import java.util.concurrent.atomic.AtomicInteger;

public class FieldsVisibility {

    private  boolean flag = true;

    private int counter = 0;

    private AtomicInteger atomicNumber = new AtomicInteger(1);

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void printNumber() {
        while (flag) {
            System.out.println("Number -> " + counter++);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int incrementAtomicNumber() {
        return this.atomicNumber.incrementAndGet();
    }

    public int getAtomicNumber() {
        return this.atomicNumber.get();
    }


}

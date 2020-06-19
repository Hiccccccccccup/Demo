import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.BitSet;
import java.util.concurrent.Executors;

public class IReadWriteLock {
    private int readCount = 0;
    private int writeCount = 0;

    public synchronized void readLock() throws InterruptedException {
        while (writeCount > 0) {
            wait();
        }
        readCount++;

    }

    public synchronized void unReadLock(){
        readCount--;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        while (writeCount > 0) {
            wait();
        }
        Thread.sleep(2000);
        writeCount++;
        System.out.println("写锁数量="+writeCount);
        while (readCount > 0) {
            wait();
        }
    }

    public synchronized void unWriteLock(){
        writeCount--;
        notifyAll();
    }


    public static void main(String[] args) {
        IReadWriteLock lock = new IReadWriteLock();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lock.writeLock();
                    System.out.println("1执行写操作");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unWriteLock();
                    System.out.println("1释放");
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    lock.writeLock();
                    System.out.println("2执行写操作");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unWriteLock();
                    System.out.println("2释放");
                }
            }
        }).start();
    }



}

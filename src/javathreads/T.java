package javathreads;

public class T {

    public static void main(String[] args) {
        TortoiseRace a = new TortoiseRace();
        Thread runner1 = new Thread(a);
        RabbitRace b = new RabbitRace();
        Thread runner2 = new Thread(b);
        runner1.start();
        runner2.start();
        while (ready < 2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    static Object lock = new Object();
    static int ready = 0;
}

class TortoiseRace implements Runnable {
    public void run() {
        synchronized (T.lock) {
            T.ready++;
            try {
                T.lock.wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        int TortoiseDistance = 0;
        for (int i = 0; TortoiseDistance <= 1000; i++) {
            TortoiseDistance++;
            System.out.println("The turtle ran 1 meter!");
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("The tortoise has finished the race!");

    }
}

class RabbitRace implements Runnable {
    public void run() {
        T.ready++;
        synchronized (T.lock) {
            try {
                T.lock.wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        int RabbitDistance = 0;
        for (int j = 0; RabbitDistance <= 1000; j++) {
            RabbitDistance += 5;
            System.out.println("The rabbit ran 5 meters!");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("The rabbit has finished the race!");

    }
}

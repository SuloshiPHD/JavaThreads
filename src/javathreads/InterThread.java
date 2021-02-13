/*
package javathreads;


class Q {
    int num;
    boolean valueset = false;


    public synchronized void put(int num) {
        while (valueset) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("Put : " + num);
            this.num = num;
            valueset = true;
            notify();
        }
    }


    public synchronized void get() {
        while (!valueset) {
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("Get : " + num);

            valueset = false;
            notify();
        }
    }


}

class Producer implements Runnable {
    Q q;

    public Producer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Producer");
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            q.put(i++);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}


class Consumer implements Runnable {
    Q q;

    public Consumer(Q q) {
        this.q = q;
        Thread t = new Thread(this, "Consumer");
        t.start();
    }

    @Override
    public void run() {

        while (true) {
            q.get();
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
}

public class InterThread {

    public static void main(String[] args) {
        Q q = new Q();
        new Producer(q);
        new Consumer(q);

    }
}
*/

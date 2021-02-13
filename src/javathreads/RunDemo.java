package javathreads;

import static java.lang.Thread.sleep;



public class RunDemo {



    public static class ExampleThread implements Runnable {

        public void run()
        {

            System.out.println(Thread.currentThread().getName()
                    + ", executing run() method!");
        }

        public  static void main(String[] args)
        {
            System.out.println("Main thread is- "
                    + Thread.currentThread().getName());
            Runnable obj = new ExampleThread();

            Thread t1 = new Thread(obj);
            t1.start();
        }



    }

}

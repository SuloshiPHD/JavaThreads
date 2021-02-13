package javathreads;

public class ExampleClass implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread has ended");
    }

    public static void main(String[] args) {
        Runnable ex = new ExampleClass();
        Thread t1= new Thread(ex);
        t1.start();
        System.out.println("Hi");
    }
}
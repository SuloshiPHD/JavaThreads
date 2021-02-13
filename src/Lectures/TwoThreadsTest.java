package Lectures;

public class TwoThreadsTest{

    public static void main(String[] args) {
        // Declare 2 thread variables
        Thread firstThrd ;
        Thread secondThrd ;
// Create the 2 threads
        firstThrd = new SimpleThread( "FirstDThread" ) ;
        secondThrd = new SimpleThread( "SecondThread" ) ;
// Start the 2 threads executing
        firstThrd.start() ;
        secondThrd.start() ;
        System.out.println("Thread name 1 :" + firstThrd.getName());
        System.out.println("Thread name 2 :" + secondThrd.getName());
        System.out.println("thread 1 priority " + firstThrd.getPriority());
        System.out.println("thread 2 priority " + secondThrd.getPriority());
        System.out.println(Thread.MAX_PRIORITY);

        ThreadGroup tg = new ThreadGroup("duneesha");

    }
}
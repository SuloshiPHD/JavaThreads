package Examples;

import java.util.concurrent.Semaphore;


class T1 extends Thread // [1]
{
    private final Semaphore T1_ProgressSema ; // [1]
    private final Semaphore T2_ProgressSema ; //
    T1( Semaphore t1sema, Semaphore t2sema ) // [1]
    {
        super("T1") ; //
        this.T1_ProgressSema = t1sema ; // [1]
        this.T2_ProgressSema = t2sema ; //
    }
    public void run()
    {
        try{
            T1_ProgressSema.acquire() ; // [1]
            System.out.println( "T1: Action 1") ;
            T2_ProgressSema.release() ; // [1]
            T1_ProgressSema.acquire() ; // [1]
            System.out.println( "T1: Action 3") ;
            T2_ProgressSema.release() ; // [1]
        } catch ( InterruptedException ie ){} ;
    } // run
} // T1
class T2 extends Thread
{
    private final Semaphore T1_ProgressSema ;
    private final Semaphore T2_ProgressSema ;
    T2( Semaphore t1sema, Semaphore t2sema )
    {
        super("T2") ;
        this.T1_ProgressSema = t1sema ;
        this.T2_ProgressSema = t2sema ; // [1]
    }
    public void run()
    {
        try{
            T2_ProgressSema.acquire() ; // [1]
            System.out.println( "T2: Action 2" ) ;
            T1_ProgressSema.release() ; // [1]
            T2_ProgressSema.acquire() ;
            System.out.println( "T2: Action 4" ) ;
            T1_ProgressSema.release() ; // [1]
        } catch ( InterruptedException ie ){} ;
    }
} // T2

class OrderActions_T1_T2 {
    private static final int NumberOfPermits = 1; // Binary Semaphore

    public static void main(String args[]) {
// create two binary semaphores to control progress of T1 & T2
        Semaphore T1_semaphore = new Semaphore(NumberOfPermits); // [1]
        Semaphore T2_semaphore = new Semaphore(NumberOfPermits); // [1]
// T1_semaphore = 1, initial acquire (claim) succeeds
// T2_semaphore = 0, initial acquire (claim) block
        int numpermits = T2_semaphore.drainPermits(); // [1]
// create & start the 2 Threads
        Thread T1 = new T1(T1_semaphore, T2_semaphore); // [1]
        Thread T2 = new T2(T1_semaphore, T2_semaphore); // [1]
        T1.start(); // [1]
        T2.start(); //
    }
} // OrderActions_T1_T2

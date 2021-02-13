package javathreads;

class TwoThreadsTest // the ‘‘main’’ class (program)
{
    public static void main ( String args )
    {
// Declare 2 thread variables
        Thread firstThrd ;
        Thread secondThrd ;
// Create the 2 threads
        firstThrd = new SimpleThread( "FirstThread" ) ;
        secondThrd = new SimpleThread( "SecondThread" ) ;
// Start the 2 threads executing
        firstThrd.start() ;
        secondThrd.start() ;
    }
} // TwoThreadsTest
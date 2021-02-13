/*
package Monitors;

class Mailbox {
    private int contents;

    public int take(){return contents;}
    public void put(int value){
    }



}

class MailboxMonitor implements Mailbox
{
    private int contents;
    private boolean available = false;

    public synchronized int take( )
    {
        while ( !available )
        {
            try {
                wait() ;
            } catch(InterruptedException e){ }
        }
        available = false ;
        notifyAll() ; // signal change of state
        return contents ;
    }
    public synchronized void put( int value )
    {
        while ( available )
        {
            try {
                wait() ;
            } catch(InterruptedException e){ }
        }
        contents = value ;
        available = true ;
        notifyAll() ; // signal change of state
    }
} // MailboxMonitor



class ProdConMailboxMonitor
{
    public static void main( String args[] )
    {
        final int NUMBITEMS = 10 ;
// Create: MailboxMonitor, Producer & Consumer
        Mailbox mbm = new MailboxMonitor() ;
        Producer p1 = new Producer( mbm, 1, NUMBITEMS ) ;
        Consumer c1 = new Consumer( mbm, 1, NUMBITEMS ) ;
// Start Producer & Consumer
        p1.start() ;
        c1.start() ;
    }
}
*/



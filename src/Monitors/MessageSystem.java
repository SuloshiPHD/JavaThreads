package Monitors;


class Poster extends Thread {
    private final MessageBoard messageboard;

    public Poster(MessageBoard mb) {
        super();
        messageboard = mb;
    }

    public void run() {
        messageboard.post(new String("Hello mate."));
        messageboard.post(new String("Good Luck."));
    }
}

class Retriever extends Thread {
    private final MessageBoard messageboard;

    public Retriever(MessageBoard mb) {
        super();
        messageboard = mb;
    }

    public void run() {
        Object message = null;

        message = messageboard.retrieve();
        message = messageboard.retrieve();
    }
}

class MessageBoard {
    private Object message = null;
    private boolean message_posted = false;

    public synchronized Object retrieve() {
        while (!message_posted) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        message_posted = false;
        notify();
        return message;
    }

    public synchronized void post(Object new_message) {
        while (message_posted) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        message = new_message;
        message_posted = true;
        notify();
    }
}


class MessageSystem {
    public static void main(String args[]) {
        MessageBoard mb = new MessageBoard();
        Poster p = new Poster(mb);
        Retriever r = new Retriever(mb);

        p.start();
        r.start();
    }
}

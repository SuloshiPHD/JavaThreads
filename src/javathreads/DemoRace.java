public class DemoRace {
    public static void main(String[] args) {
        Racer racer = new Racer();
        Thread tortoiseThread = new Thread(racer,"Tortoise");
        Thread hareThread = new Thread(racer,"Hare");
        //Tell threads to start the race
        tortoiseThread.start();
        hareThread.start();
    }
}

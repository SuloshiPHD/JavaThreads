public class Racer implements Runnable{

    public static String winner;

public void race(){
for(int distance=1; distance<=50; distance++){
        System.out.println(Thread.currentThread().getName() + " ran " + distance + " meters");
    //check if the race is finished if someone has already won
    boolean isRaceWon = isRaceWon(distance);
    if(isRaceWon){
        break;
    }
}
}

private boolean isRaceWon(int totalDistanceCovered){
boolean isRaceWon = false;
if(Racer.winner == null && totalDistanceCovered==50){
String winnerName = Thread.currentThread().getName();
Racer.winner = winnerName; //setting the winner name
    System.out.println("Winner is "+winnerName);
    isRaceWon = true;
}else if(Racer.winner == null && totalDistanceCovered < 10){
    isRaceWon = false; //not finished yet
}else if(Racer.winner != null){
    isRaceWon = true; //race has already finished
}
return isRaceWon;
}
@Override
    public void run(){
    this.race();
}
}
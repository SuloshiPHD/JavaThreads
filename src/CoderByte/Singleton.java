package CoderByte;

public class Singleton {
    public static void main(String[] args) {

        Abc object = Abc.getInstances();
    }
}

class Abc {

    public static Abc obj = new Abc();

    private Abc(){

    }

  public static Abc getInstances(){
        return obj;
  }
}

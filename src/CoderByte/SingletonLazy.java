package CoderByte;

public class SingletonLazy {
    public static void main(String[] args) {
        Abc2 x = Abc2.getInstance();
    }

}

class Abc2 {

    private static Abc2 single_instance = null;
    public String s;

    private Abc2(){
        s = "Hello I am a string part of Singleton class";
    }

    public static Abc2 getInstance()
    {
        if (single_instance == null)
            single_instance = new Abc2();

        return single_instance;
    }
}

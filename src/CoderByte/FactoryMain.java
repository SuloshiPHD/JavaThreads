package CoderByte;

public class FactoryMain {

    public static void main(String[] args) {
             OS obj = (OS) new Andrroid();
             obj.spec();
    }
}

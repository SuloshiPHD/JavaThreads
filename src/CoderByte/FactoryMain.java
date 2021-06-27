package CoderByte;

public class FactoryMain {

    public static void main(String[] args) {
        OperatingSystemFactory osf = new OperatingSystemFactory();
        OS obj = osf.getInstance("Open");
        obj.spec();

        OS obj2 = osf.getInstance("Closed");
        obj2.spec();

        OS obj3 = osf.getInstance("");
        obj3.spec();



            // OS obj = new Andrroid();
            // obj.spec();
    }
}

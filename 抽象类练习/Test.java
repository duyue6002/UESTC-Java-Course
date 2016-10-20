/**
 * Created by duyue on 2016/10/17.
 */
 
public class Test {
    public static void main(String[] args) {
        Vehicle car = new Car();
        System.out.println("Number of car's wheels:" + car.NoOfWheels());
        Vehicle motorbike = new Motorbike();
        System.out.println("Number of motorbike's wheels:" + motorbike.NoOfWheels());
    }
}

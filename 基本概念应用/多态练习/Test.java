/**
 * Created by duyue on 2016/10/18.
 */

public class Test {
    public static void main(String[] args) {
        Rodent[] animals = new Rodent[3];

        animals[0] = new Mouse("Mouse", 9, 20, 1);
        animals[1] = new Gerbil("Gerbil", 12, 50, 2);
        animals[2] = new Hamster("Hamster", 10, 120, 3);

        for(int i = 0; i < 3; i++)
        {
            System.out.println("The information of "+animals[i].getName()+" is:");
            System.out.println("Name:" + animals[i].getName() + "\nLength:" + animals[i].getLength() + "cm"
                    + "\nWeight:" + animals[i].getWeight() + "g" + "\nLifetime:" + animals[i].getLifetime() + "years");
            animals[i].food();
            animals[i].enemy();
            System.out.println();
        }
    }
}

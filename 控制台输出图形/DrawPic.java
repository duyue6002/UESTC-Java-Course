package draw;

/**
 * Created by duyue on 2016/10/16.
 */

public class DrawPic {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle();
        rectangle1.length = 10;
        rectangle1.width = 5;
        rectangle1.isHollow();
        rectangle1.isSolid();

        Rectangle rectangle2 = new Rectangle(10, 5);
        rectangle2.isHollow();
        rectangle2.isSolid();

        Triangle triangle1 = new Triangle();
        triangle1.height = 5;
        triangle1.isHollow();
        triangle1.isSolid();

        Triangle triangle2 = new Triangle(5);
        triangle2.isHollow();
        triangle2.isSolid();
    }
}

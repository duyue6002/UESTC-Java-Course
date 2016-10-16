package draw;

/**
 * Created by duyue on 2016/10/16.
 */

public class Rectangle {
    int length;
    int width;

    Rectangle() {
        System.out.println("现在是默认构造方法实现：\n");
    }

    Rectangle(int length, int width) {
        System.out.println("现在是非默认构造方法实现：\n");
        this.length = length;
        this.width = width;
    }

    void isHollow() {
        System.out.println("空心长方形：");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || i == width - 1) {
                    System.out.print("* ");
                } else {
                    if (j == 0 || j == length - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    void isSolid() {
        System.out.println("实心长方形：");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

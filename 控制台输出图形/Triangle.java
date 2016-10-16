package draw;

/**
 * Created by duyue on 2016/10/16.
 */

public class Triangle {
    int height;

    Triangle() {
        System.out.println("现在是默认构造方法实现：\n");
    }

    Triangle(int height) {
        System.out.println("现在是非默认构造方法实现：\n");
        this.height = height;
    }

    void isHollow() {
        System.out.println("空心三角形：");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < 2 * height - 1; j++) {
                if (i == height - 1) {
                    System.out.print("* ");
                } else {
                    if (j == height - i - 1 || j == height + i - 1) {
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
        System.out.println("实心三角形：");
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < 2 * height - 1; j++) {
                if (j >= height - i - 1 && j <= height + i - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

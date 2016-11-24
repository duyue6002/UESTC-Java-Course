package Yue.Merge;

import java.util.Scanner;

/**
 * @author duyue
 *         <p/>
 *         这是一个测试类，用于展示结果。
 */

public class TestThread {
    public static void main(String[] args) {
        new MoreThreads(1);
        System.out.println("--------------------------------");
        new MoreThreads(2);
        System.out.println("--------------------------------");
        new MoreThreads(3);
        System.out.println("--------------------------------");
        System.out.println("你还想尝试更多线程处理归并排序吗？(y:yes, n:no)");
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            if (s.equals("n")) {
                System.out.println("byebye!");
                in.close();
                break;
            } else if (s.equals("y")) {
                System.out.println("请输入要尝试的线程数：");
                new MoreThreads(in.nextInt());
                System.out.println("--------------------------------");
                System.out.println("你还想尝试更多线程处理归并排序吗？(y:yes, n:no)");
            } else
                System.out.println("输入错误！请重新输入");
        }
    }
}

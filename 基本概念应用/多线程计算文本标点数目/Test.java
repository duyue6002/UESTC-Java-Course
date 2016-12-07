package Yue.IO;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("一个线程：");
        new SetThread(1);
        System.out.println("-------------------------------");
        System.out.println("两个线程：");
        new SetThread(2);
    }
}

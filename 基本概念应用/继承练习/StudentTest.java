/**
 * 测试类
 */

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("Tom", 'M', 16);
        System.out.println("这是初始化后的结果：\n" + student.getData());
        student.setData("Marry", 'F', 15, 3100, 12);
        System.out.println("\n这是重新设置后的结果：\n" + student.getData());
    }
}

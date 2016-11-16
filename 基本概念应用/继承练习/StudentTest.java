/**
 * Created by duyue on 2016/10/17.
 */

public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student("Tom", 'M', 16);
        student.setData("Marry", 'F', 15, 3100, 12);
        System.out.println(student.getData());
    }
}

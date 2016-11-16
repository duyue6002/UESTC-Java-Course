package myException;

public class TryTest {
    public TryTest() {
        try {
            int a[] = new int[2];
            a[4] = 8;
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Exception msg: " + e.getMessage());
            System.err.println("Exception string: " + e.toString());
            e.printStackTrace();
        } finally {
            System.out.println("-------------------");
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        new TryTest();
    }
}

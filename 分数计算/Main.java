import java.util.Scanner;

class Fraction {
    int a, b;

    public Fraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public double toDouble() {
        double aa = (double) a;
        double bb = (double) b;
        return aa / bb;
    }

    public Fraction plus(Fraction r) {
        Fraction plus = new Fraction(a, b);
        int aa = plus.a * r.b + plus.b * r.a;
        int bb = plus.b * r.b;
        plus.a = aa;
        plus.b = bb;
        return plus;
    }

    public Fraction multiply(Fraction r) {
        Fraction multiply = new Fraction(a, b);
        int aa = multiply.a * r.a;
        int bb = multiply.b * r.b;
        multiply.a = aa;
        multiply.b = bb;
        return multiply;
    }

    public void print() {

        //求出最大公因数
        int x = this.a;
        int y = this.b;
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        this.a = this.a / x;
        this.b = this.b / x;

        //输出
        if (b != 1) {
            System.out.println(this.a + "/" + this.b);
        } else {
            System.out.println(1);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

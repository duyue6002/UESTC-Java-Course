/**
 * Created by duyue on 2016/10/14.
 */

import java.util.Scanner;
import java.math.BigInteger;

public class Fibonacci {
    int length;

    //通过输出不同项数的Fibonacci数列尽可能精确的计算黄金分割比例
    Fibonacci(int length) {
        this.length = length;
    }

    BigInteger firstNum = BigInteger.ONE;
    BigInteger secondNum = BigInteger.ONE;
    BigInteger thirdNum = BigInteger.ZERO;
    BigInteger[] FibNum = new BigInteger[5000];

    //比递归方法快很多
    BigInteger getFibNum(int j) {
        if (j == 0 || j == 1) {
            thirdNum = BigInteger.ONE;
        } else {
            thirdNum = secondNum.add(firstNum);
            firstNum = secondNum;
            secondNum = thirdNum;
        }
        return thirdNum;
    }

    void printFib() {
        for (int i = 0; i < this.length; i++) {
            FibNum[i] = getFibNum(i);
            System.out.println(FibNum[i]);
        }
    }

    void printGolRat() {

        /**
         * 最后三项相邻两项分别相除（小除大），通过两个商来比较精确位数
         * 由于BigInteger型数值转换成double型数值计算的位数固定，此方法不适用
         * 决定将商的每一位数逐个求出，分别赋值在两个数列中，通过比较数列的相同数字的个数，来确定精确位数
         * 以下是具体实现方法：
         */

        int[] ans1 = new int[5000];        //假设计算最多精确到5000位
        int[] ans2 = new int[5000];

        //计算最后两项得出的黄金分割比小数点后的数字
        firstNum = FibNum[length - 1];        //最后三项中最大的数
        secondNum = FibNum[length - 2];
        thirdNum = FibNum[length - 3];        //最后三项中最小的数
        for (int i = 0; i < 5000; i++) {
            //除数不变，被除数=余数*10
            secondNum = (secondNum.mod(firstNum).multiply(BigInteger.TEN));
            ans1[i] = secondNum.divide(firstNum).intValue();
        }


        //计算倒数第二项和倒数第三项得出的黄金分割比小数点后的数字
        firstNum = FibNum[length - 1];        //最后三项中最大的数
        secondNum = FibNum[length - 2];
        thirdNum = FibNum[length - 3];        //最后三项中最小的数
        for (int i = 0; i < 5000; i++) {
            //除数不变，被除数=余数*10
            thirdNum = (thirdNum.mod(secondNum).multiply(BigInteger.TEN));
            ans2[i] = thirdNum.divide(secondNum).intValue();
        }

        //比较两个结果相同位数
        int count;
        for (count = 0; count < 5000; count++) {
            if (ans1[count] != ans2[count])
                break;
        }
        System.out.print(length + "项Fibonacci数列可以精确到小数点后" + count + "位");

    }

    public static void main(String[] args) {
        System.out.print("Enter the length of the Fibonacci sequence:");
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        Fibonacci array = new Fibonacci(length);
        System.out.println("Fibonacci数列各项如下:");
        array.printFib();
        array.printGolRat();

    }
}

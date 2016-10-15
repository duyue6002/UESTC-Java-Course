import java.util.Scanner;

public class GuessNum {

    int value = (int)(Math.random()*100+1);     //定义需要猜的数字在[1,100]以内

    public static void main(String[] args) {
        GuessNum number = new GuessNum();
        System.out.println("You are playing guess number game now.");
        Scanner in = new Scanner(System.in);
        int guessNum;

        do {
            System.out.print("Enter a number in [1,100]:");
            guessNum = in.nextInt();
            if (guessNum > number.value) {
                System.out.println("Larger!");
            } else if (guessNum < number.value){
                System.out.println("Smaller!");
            }
        } while (guessNum != number.value);

        System.out.println("Bingo!");

    }
}

import java.util.Scanner;

/**
 * Created by duyue on 2016/10/15.
 */

public class MyTime {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    void addSecond(int sec){
        if (sec >= 60)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            second += sec;
            if (second >= 60) {
                second -= 60;
                addMinute(1);
            }
        }
    }

    void addMinute(int min){
        if (min >= 60)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            minute += min;
            if (minute >= 60) {
                minute -= 60;
                addHour(1);
            }
        }
    }

    void addHour(int hou){
        if (hour >= 24)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            hour += hou;
            if (hour >= 24) {
                hour -= 24;
            }
        }
    }

    void subSecond(int sec)
    {
        if (sec >= 60)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            second -= sec;
            if (second <= 60) {
                second += 60;
                subMinute(1);
            }
        }
    }

    void subMinute(int min)
    {
        if (min >= 60)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            minute -= min;
            if (minute <= 60) {
                minute += 60;
                subHour(1);
            }
        }
    }

    void subHour(int hou){
        if (hour >= 24)
        {
            System.out.println("illegal!Please enter again!");
        }
        else {
            hour -= hou;
            if (hour <= 24) {
                hour += 24;
            }
        }
    }

    void display(){
        System.out.printf("Time:%02d:%02d:%02d",hour,minute,second);
    }

    public static void main(String[] args)
    {
        int second,minute,hour;
        int method;
        MyTime time = new MyTime();
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("对时间做加法，输入：1，秒钟；2，分钟；3，小时；0，不做加法");
            method = in.nextInt();
            switch (method) {
                case 1:
                    System.out.print("输入数值：");
                    second = in.nextInt();
                    time.addSecond(second);
                    break;
                case 2:
                    System.out.print("输入数值：");
                    minute = in.nextInt();
                    time.addMinute(minute);
                    break;
                case 3:
                    System.out.print("输入数值：");
                    hour = in.nextInt();
                    time.addHour(hour);
                    break;
            }
        }while (method != 0);

        do {
            System.out.println("对时间做减法，输入：1，秒钟；2，分钟；3，小时；0，不做减法");
            method = in.nextInt();
            switch (method) {
                case 1:
                    System.out.print("输入数值：");
                    second = in.nextInt();
                    time.subSecond(second);
                    break;
                case 2:
                    System.out.print("输入数值：");
                    minute = in.nextInt();
                    time.subMinute(minute);
                    break;
                case 3:
                    System.out.print("输入数值：");
                    hour = in.nextInt();
                    time.subHour(hour);
                    break;
            }
        }while (method != 0);

        time.display();
    }

}

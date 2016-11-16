package main;

/**
 * Created by duyue on 2016/10/24.
 */
public interface QuackBehavior {
    void quack();
}

class Quack1 implements QuackBehavior {
    public void quack() {
        System.out.println("嘎嘎嘎嘎....");
    }
}

class Quack2 implements QuackBehavior {
    public void quack() {
        System.out.println("咯咯咯咯....");
    }
}

class Quack3 implements QuackBehavior {
    public void quack() {
        System.out.println("咔咔咔咔....");
    }
}

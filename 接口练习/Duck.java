package main;

/**
 * Created by duyue on 2016/10/24.
 */

public abstract class Duck {

    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    void swim() {
        System.out.println("游啊游....");
    }

    void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    void performFly() {
        this.flyBehavior.fly();
    }

    void performQuack() {
        this.quackBehavior.quack();
    }

    abstract void display();
}

class MallardDuck extends Duck {
    public MallardDuck() {
        setFlyBehavior(new FlyNoWay());
        setQuackBehavior(new Quack1());
    }

    void display() {
        System.out.println("MallardDuck:");
        super.swim();
        System.out.println("不知道长啥样....");
    }
}

class RedheadDuck extends Duck {
    public RedheadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack2());
    }

    void display() {
        System.out.println("RedheadDuck:");
        super.swim();
        System.out.println("头是红色的~");
    }
}

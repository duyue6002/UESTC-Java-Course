package main;

/**
 * Created by duyue on 2016/10/24.
 */
public interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {
    public void fly() {
        System.out.println("有翅膀就可以飞哟~");
    }
}

class FlyNoWay implements FlyBehavior {
    public void fly() {
        System.out.println("不会飞....");
    }
}

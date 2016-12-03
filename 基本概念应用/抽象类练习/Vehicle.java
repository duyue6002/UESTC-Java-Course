/**
 * 包含一个抽象类和它的两个子类
 */

abstract class Vehicle {
    String NoOfWheels() {
        return "Three";
    }
}

class Car extends Vehicle {
    String NoOfWheels() {
        return "四轮车";
    }
}

class Motorbike extends Vehicle {
    String NoOfWheels() {
        return "Two";
    }
}

/**
 * Created by duyue on 2016/10/17.
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

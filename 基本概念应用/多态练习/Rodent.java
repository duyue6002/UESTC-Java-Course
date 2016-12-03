/**
 * 包含一个父类和它的三个子类，子类对父类有不同的继承，形成多态
 */

class Rodent {
    String name;
    int length;
    int weight;
    int lifetime;

    Rodent(String name, int length, int weight, int lifetime) {
        this.name = name;
        this.length = length;
        this.weight = weight;
        this.lifetime = lifetime;
    }

    String getName() {
        return name;
    }

    int getLength() {
        return length;
    }

    int getWeight() {
        return weight;
    }

    int getLifetime() {
        return lifetime;
    }

    void food() {
        System.out.println("What does rodent eat?");
    }

    void enemy() {
        System.out.println("What is rodent afraid of?");
    }

}

/**
 * 子类一
 */
class Mouse extends Rodent {

    Mouse(String name, int length, int weight, int lifetime) {
        super(name, length, weight, lifetime);
    }

    void food() {
        System.out.println("The food of mouse is nut and meat.");
    }

    void enemy() {
        System.out.println("The enemy of mouse is cat and snake.");
    }
}

/**
 * 子类二
 */

class Gerbil extends Rodent {

    Gerbil(String name, int length, int weight, int lifetime) {
        super(name, length, weight, lifetime);
    }

    void food() {
        System.out.println("The food of gerbil is insect.");
    }

    void enemy() {
        System.out.println("The enemy of gerbil is rattlesnake.");
    }
}

/**
 * 子类三
 */

class Hamster extends Rodent {

    Hamster(String name, int length, int weight, int lifetime) {
        super(name, length, weight, lifetime);
    }

    void food() {
        System.out.println("The food of hamster is nut and fruit.");
    }

    void enemy() {
        System.out.println("The enemy of hamster is owl and cat.");
    }
}

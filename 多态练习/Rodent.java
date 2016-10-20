/**
 * Created by duyue on 2016/10/17.
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

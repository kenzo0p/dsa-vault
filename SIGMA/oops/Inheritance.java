public class Inheritance {
    public static void main(String[] args) {
        // Fish shark = new Fish();
        // shark.eat();
        // shark.breathe();
        // shark.swim();

        Dog kuku = new Dog();
        kuku.eat();
        kuku.legs = 4;
        System.out.println(kuku.legs);

    }
}

// base or parent class
class Animal {
    String color;

    void eat() {
        System.out.println("Eats");
    }

    void breathe() {
        System.out.println("Breathes");
    }
}

// derived or child class

class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swima in water");
    }
}

class Mamal extends Animal {
    int legs;

    void walk() {
        System.out.println("walks");
    }

}

class Dog extends Mamal {
    String breed;
}

class Bird extends Animal {
    void fly() {
        System.out.println("Fly");
    }
}

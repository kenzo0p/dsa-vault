public class Abstraction {
    public static void main(String[] args) {
        // Horse h = new Horse();
        // h.eat();
        // h.walk();
        // h.changeColor();

        Mustang m = new Mustang();
    }
}

// hiding all unnessaesary details and showing only the important parts to the
// user
abstract class Animal {            
    private String color;

    Animal() {
        color = "Brown";
        System.out.println("Animal constructor called");
    }

    public void changeColor(String color){
        this.color = color;
    }

    void eat() {
        System.out.println("Animal eats");
    }

    abstract void walk();
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse constructor called");
    }

    void changeColor() {
        changeColor("dark brown");

    }

    void walk() {
        System.out.println("Horse walks on four legs");
    }
}

class Chicken extends Animal {
    Chicken() {
        System.out.println("Chicken constructor called");
    }

    void changeColor() {
        changeColor("Yellow");
    }

    void walk() {
        System.out.println("Walks on two legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called");
    }


}
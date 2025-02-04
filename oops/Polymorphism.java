public class Polymorphism {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        // System.out.println(cal.sum(1,2));
        // System.out.println(cal.sum(1.2f,2.2f));
        // System.out.println(cal.sum(1,2 , 3));

        Deer d = new Deer();
        d.eat();
    }
}

// method overloading compile time poly
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

// method overriding runtime polymorphism

class Animal {
    void eat() {
        System.out.println("Eats everything");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eat Grass");
    }
}
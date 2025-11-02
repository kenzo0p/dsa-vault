package oops.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape randomShape = new Shape();
        randomShape.draw();
        randomShape.draw("blue");

        Shape bangle =new Circle();
        bangle.draw();
    }
    
}

package oops.Polymorphism;

public class Shape {
    //Method overriding allows a subsclass to provide a specific implementation of a method already  defined in its suerclass
    public void draw(){
        System.out.println("Drawing a shape");
    }
    public void draw(String color){
        System.out.println("Drawing a shape with the color " + color);
    }
    public static void main(String[] args) {
        
    }
}

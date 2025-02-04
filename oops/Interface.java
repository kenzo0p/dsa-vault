public class Interface {
    public static void main(String[] args) {
        // for multiple inheritance
        // Queen n = new Queen();
        // n.moves();
        // Student s1 = new Student();
        // s1.schoolName = "VVM";
        // Student s2 = new Student();
        // System.out.println(s2.schoolName);
        // Student s3 = new Student();
        // s1.schoolName = "HII";
        // System.out.println(s3.schoolName);
        // System.out.println(s1.schoolName);
        // System.out.println(s2.schoolName);
        Horse h1  = new Horse();
        System.out.println(h1.color);
        
    }
}

interface ChessPlayer {
    void moves();// in inteface its by default abstract

}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up , down  , left  , diagonal (in all four direction)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up , down  , left  , right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up , down  , left  , right , diagonal (by one step)");
    }
}


// static keyword
class Student {
    int roll;
    int marks;
    int percentage;
    String name;
    static String schoolName;
    
    void setName(String name){
        this.name = name;

    }

    String getName(){
        return this.name;
    }
}

// Super keyword

class Animal {
    String color;
    Animal() {
        System.out.println("Animal constructor is called");
    }
}


class Horse extends Animal {
    Horse(){
        super.color = "brown";
        System.out.println("Horse constructor is called");
    }
}

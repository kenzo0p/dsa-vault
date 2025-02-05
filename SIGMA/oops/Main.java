public class Main {
    public static void main(String[] args) {
        Pen p1 = new Pen();// created pen object called p1
        p1.setColor("blue");
        p1.tip(6);
        System.out.println(p1.getColor() + " " + p1.getTip());
        Student s1 = new Student();
        s1.name = "om";
        s1.roll = 456;
        s1.password = "abcd";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student(s1);
        s2.password = "asdg";
        s1.marks[2] = 100;
        for(int i = 0;i<3;i++){
            System.out.println(s2.marks[i]);
        }
        // System.out.println(s1.password);
        // System.out.println(s2.password);

        // System.out.print(s1.name);
        // BankAccount myAccount = new BankAccount();
        // myAccount.username = "om";
        // myAccount.password = "ifvbfbhfhvbhfbv";
        // myAccount.setPassword("ksjbcddcjdcdjcbj");
        // System.out.println(myAccount.);
    }
}

// class BankAccount {
// public String username;
// private String password;

// public void setPassword(String pwd){
// password = pwd;
// }

// }

class Pen {
    private String color;
    private int tip;

    String getColor() {
        return this.color; // this keyword is used to refer to the current object
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    int getTip() {
        return this.tip;
    }

    void tip(int tip) {
        this.tip = tip;
    }
}

// class Student {
// String name;
// int age;
// float percentage;

// void calculatePer(int py, int chem, int math) {
// percentage = (py + chem + math) / 3;
// }
// }

class Student {
    String name;
    int roll;
    String password;
    int marks[];


    // shallow copy constructor //marks willl change
    // Student(Student s1) {
    //     marks = new int[3];
    //     this.name = name;
    //     this.roll = roll;
    //     this.marks = s1.marks;
    // }

    // deep copy constructor //unchanged marks
    Student(Student s1){
        marks = new int[3];
        this.name = name;
        this.roll = roll;
        for(int i = 0;i<marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
    }

    Student() {
        marks = new int[3];
        System.out.println("Constructor is called....");
    }

    Student(int roll) {
        marks = new int[3];
        this.roll = roll;
        // System.out.println("Constructor is called....");
    }

    Student(String name) {
        marks = new int[3];
        this.name = name;
        // System.out.println("Constructor is called....");
    }

}

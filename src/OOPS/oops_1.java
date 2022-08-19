package OOPS;


class Pen{
    //blueprint of a pen

    //attributes
    String color;
    String type; //ballpoint or gel

    //behaviour -> methods
    public void write(){
        System.out.println("Writing something");
    }

    public void printColor(){
        System.out.println(color);
    }
}

class Student{

    String name;
    int age;

    public void printInfo(){
        System.out.println(this.name);
        System.out.println(this.age);
    }

    //non - parameterized constructor
    Student(){
        System.out.println("constructor called");
    }

    //parameterized constructor
    Student(String name , int age){
        this.name = name;
        this.age = age;
    }

    //copy constructor - copy one object's data into another object
    Student(Student s2){
        this.name = s2.name;
        this.age = s2.age;
    }

}


public class oops_1 {
    public static void main(String args[]){
//        Pen pen1 = new Pen();
//        pen1.color = "blue";
//        pen1.type = "gel";
//        pen1.printColor();
//
//        Pen pen2 = new Pen();
//        pen2.color = "black";
//        pen2.type = "ballpoint";
//        pen2.printColor();


        Student s1 = new Student();
        s1.name = "aman";
        s1.age = 24;
       // s1.printInfo();

        Student s2 = new Student("nsingh" , 21);
        //s2.printInfo();

        Student s3 = new Student(s2);
        s3.printInfo();



    }

}

package com.mansour;

public class Main {
    public static void main(String[] args) {

        //TIP polymorphism means same method but different implementations. If a class has more than just one IS-A relationship then its polymorphic. All java objects are polymorphic since they extend the Object class by default.


        //TIP compile time polymorphism, same function name but different implementations (Static polymorphism). Its performed using method overloading.
        Calculator calculator = new Calculator();
        System.out.println("Adding two integers: " + calculator.addition(1, 2));
        System.out.println("Adding two doubles: " + calculator.addition(5.5, 8.3));
        System.out.println("Adding integer var args: " + calculator.addition(1, 2, 3, 4, 5));
        System.out.println();
        //TIP run time polymorphism (dynamic method dispatch) using method overriding. It's the JVM's responsibility to call the correct method depending on the Object type at run time while the compiler should make sure that the method already exists in the reference type object at compile time.
        Animal animal1 = new Deer();    //Upcasting
        Animal animal2 = new Bird();    //Upcasting
        //Calling the overridden method move() of Deer class.
        animal1.move();
        //Calling the overridden method move() of bird class.
        animal2.move();

        System.out.println();
        //TIP Virtual methods are overridden methods invoked at run time no matter what datta type the reference is that was used in the source code at compile time. So, dear1 is of type Animal and the compiler verifies that the method move() exists in this class at the compile time but the JVM calls the move() method from the object type at run time that's why its calling move() from Deer class despite the reference type is Animal.
        Animal dear1 = new Deer();
        Deer dear2 = new Deer();
        dear1.move();
        dear2.move();
    }
}

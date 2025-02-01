public class Car extends Vehicle {
    //A Class is an entity which holds data(attributes) and can perform actions(Methods)
    //Attributes
    String make="Ford",model="Mustang";
    int year=2025;
    double price=580000.99;
    boolean isRunning=false;
    //methods
    void start(){
        isRunning=true;
        System.out.println("Car Started");
    }
    void stop(){
        isRunning=false;
        System.out.println("Car Stopped");
    }

    @Override
    void go() {
        System.out.println(("You drive the car"));
    }
}

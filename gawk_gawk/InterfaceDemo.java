// Define the interface
interface Vehicle {
    // Abstract method (interface methods are implicitly public and abstract)
    void start();
    
    void stop();
}

// Implement the interface in a class
class Car implements Vehicle {

    // Providing implementation for start()
    public void start() {
        System.out.println("Car is starting...");
    }

    // Providing implementation for stop()
    public void stop() {
        System.out.println("Car is stopping...");
    }
}

// Another class implementing the same interface
class Bike implements Vehicle {

    public void start() {
        System.out.println("Bike is starting...");
    }

    public void stop() {
        System.out.println("Bike is stopping...");
    }
}

// Main class
public class InterfaceDemo {
    public static void main(String[] args) {
        Vehicle myCar = new Car();     // Upcasting to interface
        Vehicle myBike = new Bike();   // Upcasting to interface

        myCar.start();
        myCar.stop();

        myBike.start();
        myBike.stop();
    }
}

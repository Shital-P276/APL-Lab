// Parent class
class Animal {
    String name;

    // Constructor
    Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    // Method
    void display() {
        System.out.println("Animal name: " + name);
    }
}

// Child class
class Dog extends Animal {
    String breed;

    // Constructor
    Dog(String name, String breed) {
        super(name); // Call to parent class constructor
        this.breed = breed;
        System.out.println("Dog constructor called");
    }

    // Method overriding with super keyword
    @Override
    void display() {
        super.display(); // Call parent method
        System.out.println("Dog breed: " + breed);
    }
}

// Main class
public class InheritanceDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog("Tommy", "Labrador");
        myDog.display();
    }
}

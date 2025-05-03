interface Vehicle {     
    int spd = 0;     
    void start();     
    void stop();     
    int getspeed();     
    void setspeed(int val);     
    default void displayInfo() {         
        System.out.println("This is a vehicle");     
    } 
}

interface FuelPowered extends Vehicle {     
    void refuel(int amount);     
    int getFuellevel();     
    default void fuelType() {         
        System.out.println("Generic Fuel.");     
    } 
}

class Car implements FuelPowered {     
    int speed = 0;     
    int fuel;     
    int fuelLevel = 100;                  

    @Override     
    public void start() {             
        speed += 1;         
    }                  

    @Override     
    public void stop() {             
        speed = 0;         
    }                  

    @Override     
    public int getspeed() {             
        return speed;         
    }                  

    @Override     
    public void setspeed(int val) {             
        speed = val;         
    }                  

    @Override     
    public void refuel(int amount) {             
        fuel += amount;         
    }                  

    @Override     
    public int getFuellevel() {             
        return fuelLevel;         
    }                  

    @Override     
    public void fuelType() {             
        System.out.println("Car uses Petrol");         
    }                  

    @Override     
    public void displayInfo() {             
        System.out.println("This is a Car");         
    } 
}

class Bike implements FuelPowered {     
    int speed = 0;     
    int fuel = 100;       

    @Override     
    public void start() {             
        System.out.println("Bike started");         
    }                  

    @Override     
    public void refuel(int amount) {             
        fuel += amount;         
    }                  

    @Override     
    public int getspeed() {             
        return speed;         
    }                  

    @Override     
    public void setspeed(int val) {             
        speed += val;             
        System.out.println("Bike speed set to " + speed + " km/h");         
    }                  

    @Override     
    public int getFuellevel() {             
        return fuel;         
    }                  

    @Override     
    public void stop() {             
        System.out.println("Bike stopped");         
    }                  

    @Override     
    public void displayInfo() {             
        System.out.println("This is a Bike");         
    } 
}

class VehicleTest {     
    public static void main(String[] args) {         
        Vehicle[] vehicles = new Vehicle[3];          

        vehicles[0] = new Bike();           
        vehicles[1] = new Car();            
        vehicles[2] = new Car();             

        for (Vehicle vehicle : vehicles) {             
            vehicle.start();             
            vehicle.setspeed(40);             

            if (vehicle instanceof FuelPowered) {                 
                FuelPowered fuelVehicle = (FuelPowered) vehicle;                 
                fuelVehicle.refuel(40);                 
                System.out.println("Fuel level: " + fuelVehicle.getFuellevel());             
            }             

            vehicle.stop();             
            System.out.println();         
        }     
    } 
}

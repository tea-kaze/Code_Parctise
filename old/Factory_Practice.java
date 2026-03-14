//package Practice_Code;
import java.util.Scanner;

public class Factory_Practice {
    public interface Car {
        void drive();
        String color();
    }

    public static class BMW implements Car {
        @Override
        public void drive() {
            System.out.println("Driving a BMW");
        }

        @Override
        public String color() {
            return "white bule red";
        }
    }
    
    public static class Audi implements Car {
        @Override
        public void drive() {
            System.out.println("Driving an Audi");
        }

        @Override
        public String color() {
            return "silver gray";
        }
    }

    public static class AMG implements Car {
        @Override
        public void drive() {
            System.out.println("Driving an AMG");
        }

        @Override
        public String color() {
            return "black";
        }
    }

    enum CarType {
        BMW,
        AUDI,
        AMG
    }

    public static class CarFactory {
        public static Car createCar(CarType type) {
            switch (type) {
                case BMW:
                    return new BMW();
                case AUDI:
                    return new Audi();
                case AMG:
                    return new AMG();
                default:
                    return null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter car type (BMW, AUDI, AMG):");
        CarType type = CarType.valueOf(sc.nextLine().toUpperCase());
        Car car = CarFactory.createCar(type);
        if(car == null){
            System.out.println("Invalid car type");
        }else{
            car.drive();
            System.out.println("Available colors: " + car.color());
        }
        
        sc.close();
    }
}

package transport_types;

public class Car implements Transportation {
    @Override
    public double costPerHunderKilometers() {
        return 8.0;
    }

    @Override
    public void printCheckList() {
        System.out.println("You'll be traveling by car:\n" +
                "1. Make sure that all lights are working\n" +
                "2. Check the air pressure in tyres\n" +
                "3. Put a bottle of water in the car");
    }
}

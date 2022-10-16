package transport_types;

public class Plane implements Transportation{
    @Override
    public double costPerHunderKilometers() {
        return 200.0;
    }

    @Override
    public void printCheckList() {
        System.out.println("You'll be traveling by plane:\n" +
                "1. Take your passport or ID\n" +
                "2. Take your plane tickets\n" +
                "3. Make sure your doesn't exceed max weight\n" +
                "4. Make sure the liquids are in a separate plastic bag");
    }
}

package transport_types;

public class Bicycle implements Transportation{
    @Override
    public double costPerHunderKilometers() {
        return 0.0;
    }

    @Override
    public void printCheckList() {
        System.out.println("You'll be traveling by bicycle:\n" +
                "1. Take a reflective vest with you\n" +
                "2. Take the quick repair kit in case of a puncture\n");
    }
}

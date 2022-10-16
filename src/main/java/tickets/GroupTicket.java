package tickets;

public class GroupTicket extends Ticket {
    private int groupSize;

    public GroupTicket(double fullPrice, int groupSize) {
        super(fullPrice);
        this.groupSize = groupSize;
    }

    @Override
    protected double calculateDiscount() {
        if (groupSize < 5) {
            discountPercentage = 10;
        } else {
            discountPercentage = 25;
        }
        return super.calculateDiscount();
    }

    @Override
    public void placeAd() {
        System.out.println("You seem to be like a very cool gang! Why not to have another trip in this company?");
    }
}

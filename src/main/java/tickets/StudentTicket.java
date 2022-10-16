package tickets;

public class StudentTicket extends Ticket{

    public StudentTicket (double fullPrice) {
        super(fullPrice);
        discountPercentage = 20;
    }

    @Override
    public void placeAd() {
        System.out.println("Wasssup! Studies can wait! Use our services to EXPLORE the world!");
    }
}

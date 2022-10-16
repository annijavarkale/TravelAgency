package tickets;

public abstract class Ticket {
    protected double fullPrice;
    protected int discountPercentage = 0;

    public Ticket(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    private double calculateTicketPrice(){
        return fullPrice - calculateDiscount();
    }

    protected double calculateDiscount() {
        return fullPrice * discountPercentage / 100;
    }

    public void printTicketPrice(){
        System.out.printf(
                "$$$$$$$$$$$$$$$$ Tickets $$$$$$$$$$$$$$$$$$$$\n" +
                "  Full price: %.2f\n" +
                "    Discount: %.2f(%d%%)\n" +
                "       TOTAL: %.2f\n" +
                "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n",
                fullPrice, calculateDiscount(), discountPercentage,
                calculateTicketPrice());
    }



    public abstract void placeAd();
    //{
    //    System.out.println("Hey regular person. Hope you like to travel. Please use our services again.");
    //}
}



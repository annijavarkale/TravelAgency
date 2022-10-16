import tickets.Ticket;
import transport_types.Transportation;

import java.util.ArrayList;

public class Country {
    private String officialName;
    private String commonName;
    private String countryCode;
    private String cca2;
    private ArrayList<String> currencies;
    private ArrayList<String> languages;
    private double area;
    private int population;
    private Ticket ticket;
    private Transportation transportation;

    public Country(String officialName, String commonName, String countryCode,
                   String cca2, ArrayList<String> currencies,
                   ArrayList<String> languages, double area, int population) {
        this.officialName = officialName;
        this.commonName = commonName;
        this.countryCode = countryCode;
        this.cca2 = cca2;
        this.currencies = currencies;
        this.languages = languages;
        this.area = area;
        this.population = population;
        ticket = null;
        transportation = null;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    private double populationDensity() {
        return area / population;
    }

    public void printInfo() {
        System.out.printf(
                "******************** %s ********************\n" +
                "(%s), %s %s\n" +
                "Currencies: %s\n" +
                "Languages spoken: %s\n" +
                "Area: %.2f | Population: %d | Density %.3f\n" +
                "---------------------%s---------------------\n",
            officialName, commonName, countryCode, cca2,
            currencies, languages, area, population,
            populationDensity(), populateCharFiller('-')
        );
        if (transportation != null) {
            transportation.printCheckList();
            System.out.printf("---------------------%s---------------------\n", populateCharFiller('-'));
        }

        if (ticket != null) {
            ticket.printTicketPrice();
            ticket.placeAd();
            System.out.printf("---------------------%s---------------------\n", populateCharFiller('-'));
        }

        System.out.printf("*********************%s*********************\n\n", populateCharFiller('*'));
    }

    private String populateCharFiller(char character) {
        StringBuilder filler = new StringBuilder();
        for (int i = 0; i < officialName.length(); i++) {
            filler.append(character);
        }
        return filler.toString();
    }

}

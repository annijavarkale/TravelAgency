import helpers.FileHelper;
import locations.Country;
import tickets.GroupTicket;
import tickets.RegularTicket;
import tickets.StudentTicket;
import tickets.Ticket;
import transport_types.Bicycle;
import transport_types.Car;
import transport_types.Plane;
import transport_types.Transportation;

import java.util.ArrayList;
import java.util.Scanner;

import static helpers.RestAPIHelper.API_CALL_PREFIX;
import static helpers.RestAPIHelper.createCountryFromResponse;
import static java.lang.Math.random;

public class TravelAgency {
    public static void main(String[] args) {
        welcomeScreen();
    }

    private static void welcomeScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Welcome! Please select an action:\n" +
                "1 | Search country by name\n" +
                "2 | Search country by capital\n" +
                "3 | Create a trip route\n" +
                "---> ");

        String userChoice = scanner.nextLine().trim();
        switch (userChoice){
            case "1":
                searchCountryByName();
                break;
            case "2":
                searchCountryByCapital();
                break;
            case "3":
                createTripRoute();
                break;
            default:
                welcomeScreen();
                break;
        }
    }

    private static void createTripRoute() {
        int maxTicketPrice = 500;
        int minTicketPrice = 100;
        Ticket ticket = null;
        Transportation transportation = null;
        int numOfCountries;
        ArrayList<Country> tripCountries  = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        // Process ticket information
        System.out.print("Please select trip price plan\n" +
                "1 | Traveling alone\n" +
                "2 | Traveling as a student\n" +
                "3 | Traveling in a group\n" +
                "---> ");
        String pricePlan = scanner.nextLine().trim();
        double ticketFullPrice = random() * (maxTicketPrice - minTicketPrice) + minTicketPrice;
        switch (pricePlan){
            case "1":
                ticket = new RegularTicket(ticketFullPrice);
                break;
            case "2":
                ticket = new StudentTicket(ticketFullPrice);
                break;
            case "3":
                System.out.print("Please enter the amount of people in the group\n--->");
                ticket = new GroupTicket(ticketFullPrice, Integer.parseInt(scanner.nextLine()));
                break;
        }

        // Process ticket information
        System.out.print("Please select the type of transport\n" +
                "1 | Traveling by car\n" +
                "2 | Traveling by bicycle\n" +
                "3 | Traveling by plane\n" +
                "---> ");
        String transportType = scanner.nextLine().trim();
        switch (transportType) {
            case "1":
                transportation = new Car();
                break;
            case "2":
                transportation = new Bicycle();
                break;
            case "3":
                transportation = new Plane();
                break;
        }
        System.out.print("Please enter the amount of countries you want to visit:\n---->");
        numOfCountries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numOfCountries; i++) {
            System.out.print("Enter country name:\n-->");
            String countryName = scanner.nextLine();
            Country destinationCountry = createCountryFromResponse(API_CALL_PREFIX + "name/" + countryName);
            destinationCountry.setTicket(ticket);
            destinationCountry.setTransportation(transportation);
            tripCountries.add(destinationCountry);
        }
        FileHelper.saveRouteToFile(tripCountries);
        welcomeScreen();
    }

    private static void searchCountryByName() {
        searchCountryByProperty("name");
    }

    private static void searchCountryByCapital() {
        searchCountryByProperty("capital");
    }

    private static void searchCountryByProperty(String property) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please enter the %s of country:\n --->", property);
        Country country = createCountryFromResponse(API_CALL_PREFIX + property + "/"
                + scanner.nextLine().trim());

        country.printInfo();
        welcomeScreen();
    }


}

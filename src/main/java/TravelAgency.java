import tickets.StudentTicket;
import tickets.Ticket;
import transport_types.Car;
import transport_types.Plane;
import transport_types.Transportation;

import java.util.ArrayList;
import java.util.Scanner;

public class TravelAgency {
    public static void main(String[] args) {
        welcomeScreen();
    }

    private static void welcomeScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please select an action:\n" +
                "1 | Search country by name\n" +
                "2 | Create a trip route\n" +
                "---> ");

        String userChoice = scanner.nextLine();
        switch (userChoice.trim()){
            case "1":
                searchCountryByName();
                break;
            case "2":
                createTripRoute();
                break;
            default:
                welcomeScreen();
                break;
        }
    }

    private static void createTripRoute() {
        // TODO: 15.10.2022
    }

    private static void searchCountryByName() {
        // TODO: 15.10.2022 add actual searching for the country
        ArrayList<String> currencies = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();
        currencies.add("EUR");
        languages.add("Latvian");

        StudentTicket studentTicket = new StudentTicket(100.00);

        Ticket ticket = new StudentTicket(200.00);

        Car car = new Car();
        Transportation t = new Plane();

        Country testCountry = new Country("Republic of Latvia",
                "Latvia", "LAT", "LV",
                currencies, languages, 64540.00, 1900000);
        testCountry.printInfo();
    }

}

import api_helpers.RestAPIHelper;
import locations.Country;

import java.util.Scanner;

import static api_helpers.RestAPIHelper.API_CALL_PREFIX;

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
        Country country = RestAPIHelper.createCountryFromResponse(API_CALL_PREFIX + property + "/" + scanner.nextLine().trim());

        country.printInfo();
        welcomeScreen();
    }


}

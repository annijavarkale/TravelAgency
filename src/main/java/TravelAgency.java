import io.restassured.response.ResponseBody;

import java.util.ArrayList;
import java.util.Scanner;

import static api_helpers.RestAPIHelper.API_CALL_PREFIX;
import static api_helpers.RestAPIHelper.getResponseBody;

public class TravelAgency {
    public static void main(String[] args) {
        welcomeScreen();
    }

    private static void welcomeScreen() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Please select an action:\n" +
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
        // TODO: 15.10.2022
    }

    private static Country createCountryFromResponse(String apiCall) {
        ResponseBody responseBody = getResponseBody(apiCall);

        String officialName = responseBody.jsonPath().getString("name.official[0]");
        String commonName = responseBody.jsonPath().getString("name.common[0]");
        String countryCode = responseBody.jsonPath().getString("cioc[0]");
        String countryCodeShort = responseBody.jsonPath().getString("cca2[0]");
        ArrayList<String> currencies = responseBody.jsonPath().getJsonObject("currencies");
        ArrayList<String> languages = responseBody.jsonPath().getJsonObject("languages");
        double area = responseBody.jsonPath().getDouble("area[0]");
        int population = responseBody.jsonPath().getInt("population[0]");

        return new Country(officialName, commonName, countryCode,
                countryCodeShort, currencies, languages,
                area, population);
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
        Country country = createCountryFromResponse(API_CALL_PREFIX + property + "/" + scanner.nextLine().trim());

        country.printInfo();
        welcomeScreen();
    }


}

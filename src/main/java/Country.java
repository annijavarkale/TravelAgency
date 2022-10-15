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
                "---------------------%s---------------------",
            officialName, commonName, countryCode, cca2,
            currencies, languages, area, population,
            populationDensity(), populateCharFiller('-')
        );
    }

    private String populateCharFiller(char character) {
        StringBuilder filler = new StringBuilder();
        for (int i = 0; i < officialName.length(); i++) {
            filler.append(character);
        }
        return filler.toString();
    }

}

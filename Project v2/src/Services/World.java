package Services;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.util.ArrayList;

//  Clasa de serviciu
public class World {
    private static World instance = null;
    private ArrayList<Country> listOfCountries;

    private World() {
        this.listOfCountries = new ArrayList<>();
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }


    public void addCountry(Country country) {
        listOfCountries.add(country);
    }

    public void printCountries() throws IOException {
        AuditHandler.printAction("printCountries()", Thread.currentThread().getName());

        for (Country country : listOfCountries) {
            System.out.println(country.getCountryName());
        }
    }

    public Country getCountry(String countryName) {
        Country result = null;
        for (Country country : listOfCountries) {
            if (country.getCountryName().equals(countryName)) {
                result = country;
                break;
            }
        }
        return result;
    }

    public ArrayList<Country> getCountries() {
        return listOfCountries;
    }
}

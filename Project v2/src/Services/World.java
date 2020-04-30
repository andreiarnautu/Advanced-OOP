package Services;

import java.beans.ConstructorProperties;
import java.io.IOException;
import java.util.ArrayList;

//  Clasa de serviciu
public class World {
    private ArrayList<Country> listOfCountries;

    public World() {
        this.listOfCountries = new ArrayList<>();
    }

    public void addCountry(Country country) {
        listOfCountries.add(country);
    }

    public void printCountries() throws IOException {
        AuditHandler.printAction("printCountries()");

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

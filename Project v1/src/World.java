import java.beans.ConstructorProperties;
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

    public void printCountries() {
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
}

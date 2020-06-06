package Services;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//  read and write data from data/countries.csv
public class CountryService {
    private static CountryService instance = null;

    //  private constructor
    private CountryService() {
    }


    public static CountryService getInstance() {
        if (instance == null) {
            instance = new CountryService();
        }
        return instance;
    }


    public void readCountries(World world, String filePath) throws FileNotFoundException {
        File fileDescriptor = new File(filePath);
        Scanner scanner = new Scanner(fileDescriptor);

        int lineId = -1;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineId += 1;
            if (lineId == 0) {
                continue;
            }

            String[] data = line.split(",");
            Country country = new Country(data[0]);
            world.addCountry(country);
        }
    }

    public void writeCountries(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Country\n");

        ArrayList<Country> countryList = world.getCountries();
        for (Country country : countryList) {
            writer.write(country.getCountryName() + "\n");
        }
        writer.close();
    }
}

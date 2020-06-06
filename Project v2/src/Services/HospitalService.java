package Services;

import Entities.Hospital;

import java.io.*;
import java.util.Scanner;


//  read and write data from/to  "data/hospitals.csv"
public class HospitalService {
    private static HospitalService instance = null;


    private HospitalService() {
    }


    public static HospitalService getInstance() {
        if (instance == null) {
            instance = new HospitalService();
        }
        return instance;
    }

    public void readHospitals(World world, String filePath) throws FileNotFoundException {
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
            world.getCountry(data[1]).addHospital(data[0]);
        }
    }


    public void writeHospitals(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                writer.write(hospital.getHospitalName() + "," + country.getCountryName() + "\n");
            }
        }

        writer.close();
    }
}

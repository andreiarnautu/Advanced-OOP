package Services;

import Entities.Hospital;
import Entities.Janitor;

import java.io.*;
import java.util.Scanner;

public class JanitorCsvHandler {
    public static JanitorCsvHandler instance = null;


    private JanitorCsvHandler() {

    }


    public static JanitorCsvHandler getInstance() {
        if (instance == null) {
            instance = new JanitorCsvHandler();
        }
        return instance;
    }


    public void readJanitors(World world, String filePath) throws FileNotFoundException {
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

            String name = data[0];
            Integer age = Integer.parseInt(data[1]);
            Integer workShift = Integer.parseInt(data[2]);
            Integer salary = Integer.parseInt(data[3]);
            String hospital = data[4];
            String country = data[5];

            Janitor janitor = new Janitor(workShift, salary, name, age);
            world.getCountry(country).getHospital(hospital).addJanitor(janitor);
        }
    }


    public void writeJanitors(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Name,Age,Work shift,Salary,Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                for (Janitor janitor : hospital.getListOfJanitors()) {
                    writer.write(janitor.getPersonName() + "," + janitor.getAge() + "," +
                            janitor.getWorkShift() + "," + janitor.getSalary() + "," +
                            hospital.getHospitalName() + "," + country.getCountryName() + "\n");
                }
            }
        }

        writer.close();
    }
}

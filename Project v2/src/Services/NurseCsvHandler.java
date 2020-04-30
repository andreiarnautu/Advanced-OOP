package Services;

import Entities.Hospital;
import Entities.Nurse;

import java.io.*;
import java.util.Scanner;

//  read and write data from/to "data/nurses.csv"
public class NurseCsvHandler {
    public static NurseCsvHandler instance = null;


    private NurseCsvHandler() {

    }


    public static NurseCsvHandler getInstance() {
        if (instance == null) {
            instance = new NurseCsvHandler();
        }
        return instance;
    }


    public void readNurses(World world, String filePath) throws FileNotFoundException {
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
            Integer yearsOfExperience = Integer.parseInt(data[2]);
            Integer salary = Integer.parseInt(data[3]);
            String hospital = data[4];
            String country = data[5];

            Nurse nurse = new Nurse(yearsOfExperience, salary, name, age);
            world.getCountry(country).getHospital(hospital).addNurse(nurse);
        }
    }


    public void writeNurses(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Name,Age,Years of Experience,Salary,Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                for (Nurse nurse : hospital.getListOfNurses()) {
                    writer.write(nurse.getPersonName() + "," + nurse.getAge() + "," +
                            nurse.getYearsOfExperience() + "," + nurse.getSalary() + "," +
                            hospital.getHospitalName() + "," + country.getCountryName() + "\n");
                }
            }
        }

        writer.close();
    }
}

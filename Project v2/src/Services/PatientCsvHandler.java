package Services;

import Entities.Hospital;
import Entities.Janitor;
import Entities.Patient;

import java.io.*;
import java.util.Scanner;

public class PatientCsvHandler {
    public static PatientCsvHandler instance = null;


    private PatientCsvHandler() {

    }


    public static PatientCsvHandler getInstance() {
        if (instance == null) {
            instance = new PatientCsvHandler();
        }
        return instance;
    }


    public void readPatients(World world, String filePath) throws FileNotFoundException {
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
            Integer timeSinceHospitalization = Integer.parseInt(data[2]);
            String disease1 = data[3];
            String disease2 = data[4];
            String disease3 = data[5];
            String hospital = data[6];
            String country = data[7];

            Patient patient = new Patient(name, age, timeSinceHospitalization);
            if (!disease1.isBlank()) {
                patient.addDisease(disease1);
            }
            if (!disease2.isBlank()) {
                patient.addDisease(disease2);
            }
            if (!disease3.isBlank()) {
                patient.addDisease(disease3);
            }

            world.getCountry(country).getHospital(hospital).addPatient(patient);
        }
    }


    public void writePatients(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Name,Age,Time since hospitalization,Disease1,Disease2,Disease3,Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                for (Patient patient : hospital.getListOfPatients()) {
                    writer.write(patient.getPersonName() + "," + patient.getAge() + "," +
                            patient.getTimeSinceHospitalization() + ",");

                    for (int i = 0; i < 3; i++) {
                        if (patient.getListOfDiseases().size() > i) {
                            writer.write(patient.getListOfDiseases().get(i));
                        }
                        writer.write(",");
                    }
                    writer.write(hospital.getHospitalName() + "," + country.getCountryName() + "\n");
                }
            }
        }

        writer.close();
    }
}

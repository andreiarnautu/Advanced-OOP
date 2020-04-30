package Services;

import Entities.Doctor;
import Entities.Hospital;

import java.io.*;
import java.util.Scanner;

//  read and write data from/to "data/doctors.csv"
public class DoctorCsvHandler {
    public static DoctorCsvHandler instance = null;


    private DoctorCsvHandler() {

    }


    public static DoctorCsvHandler getInstance() {
        if (instance == null) {
            instance = new DoctorCsvHandler();
        }
        return instance;
    }


    public void readDoctors(World world, String filePath) throws FileNotFoundException {
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
            String areaOfExpertise = data[2];
            Integer patientsTreated = Integer.parseInt(data[3]);
            Integer salary = Integer.parseInt(data[4]);
            String hospital = data[5];
            String country = data[6];

            Doctor doctor = new Doctor(areaOfExpertise, salary, patientsTreated, name, age);
            world.getCountry(country).getHospital(hospital).addDoctor(doctor);
        }
    }


    public void writeDoctors(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Name,Age,Area of expertise,Patients treated,Salary,Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                for (Doctor doctor : hospital.getListOfDoctors()) {
                    writer.write(doctor.getPersonName() + "," + doctor.getAge() + "," +
                            doctor.getAreaOfExpertise() + "," + doctor.getPatientsTreated() + "," +
                            doctor.getSalary() + "," + hospital.getHospitalName() + "," +
                            country.getCountryName() + "\n");
                }
            }
        }

        writer.close();
    }
}

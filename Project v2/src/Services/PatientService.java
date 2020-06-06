package Services;

import Entities.Hospital;
import Entities.Nurse;
import Entities.Patient;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientService {
    public static PatientService instance = null;
    public static int idNumber = 1;


    private PatientService() {

    }


    public static PatientService getInstance() {
        if (instance == null) {
            instance = new PatientService();
        }
        return instance;
    }


    public void readPatients(DatabaseConnection connection, World world) {
        String selectStatement = "SELECT * FROM patients;";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectStatement)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                Integer age = result.getInt("age");
                Integer timeSinceHospitalization = result.getInt("time");
                String disease1 = result.getString("disease1");
                String disease2 = result.getString("disease2");
                String disease3 = result.getString("disease3");
                String hospital = result.getString("hospital");
                String country = result.getString("country");


                Patient patient = new Patient(name, age, timeSinceHospitalization);
                if (disease1 != null) {
                    patient.addDisease(disease1);
                }
                if (disease2 != null) {
                    patient.addDisease(disease2);
                }
                if (disease3 != null) {
                   patient.addDisease(disease3);
                }
                world.getCountry(country).getHospital(hospital).addPatient(patient);
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to read the patients list.");
        }
    }

    public void addPatient(DatabaseConnection connection, World world, Patient patient, String hospitalName, String countryName) {
        String insertStatement = "INSERT into patients values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(insertStatement)) {
            statement.setInt(1, idNumber);
            statement.setString(2, patient.getPersonName());
            statement.setInt(3, patient.getAge());
            statement.setInt(4, patient.getTimeSinceHospitalization());

            for (int i = 0; i < 3; i++) {
                if (patient.getListOfDiseases().size() > i) {
                    statement.setString(5 + i, patient.getListOfDiseases().get(i));
                } else {
                    statement.setString(5 + i, null);
                }
            }

            statement.setString(8, hospitalName);
            statement.setString(9, countryName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                world.getCountry(countryName).getHospital(hospitalName).addPatient(patient);
                System.out.println("A new patient was inserted successfully!");
                idNumber += 1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to insert a new patient: " + e.getMessage());
        }
    }

}

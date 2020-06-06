package Services;

import Entities.Doctor;
import Entities.Hospital;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//  read and write data from/to "data/doctors.csv"
public class DoctorService {
    public static DoctorService instance = null;
    public static Integer idNumber = 1;


    private DoctorService() {

    }


    public static DoctorService getInstance() {
        if (instance == null) {
            instance = new DoctorService();
        }
        return instance;
    }


    public void readDoctors(DatabaseConnection connection, World world) {
        String selectStatement = "SELECT * FROM doctors;";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectStatement)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                Integer age = result.getInt("age");
                String areaOfExpertise = result.getString("area");
                Integer patientsTreated = result.getInt("patients");
                Integer salary = result.getInt("salary");
                String hospital = result.getString("hospital");
                String country = result.getString("country");

                Doctor doctor = new Doctor(areaOfExpertise, salary, patientsTreated, name, age);
                world.getCountry(country).getHospital(hospital).addDoctor(doctor);
                idNumber += 1;
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to read the doctor list.");
        }
    }


    public void addDoctor(DatabaseConnection connection,  World world, Doctor doctor, String hospitalName, String countryName) {
        String insertStatement = "INSERT into doctors values (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(insertStatement)) {
            statement.setInt(1, idNumber);
            statement.setString(2, doctor.getPersonName());
            statement.setInt(3, doctor.getAge());
            statement.setString(4, doctor.getAreaOfExpertise());
            statement.setInt(5, doctor.getPatientsTreated());
            statement.setInt(6, doctor.getSalary());
            statement.setString(7, hospitalName);
            statement.setString(8, countryName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                world.getCountry(countryName).getHospital(hospitalName).addDoctor(doctor);
                System.out.println("A new doctor was inserted successfully!");
                idNumber += 1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to insert a new doctor: " + e.getMessage());
        }
    }
}

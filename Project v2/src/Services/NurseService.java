package Services;

import Entities.Hospital;
import Entities.Janitor;
import Entities.Nurse;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//  read and write data from/to "data/nurses.csv"
public class NurseService {
    public static NurseService instance = null;
    public Integer idNumber = 1;

    private NurseService() {

    }


    public static NurseService getInstance() {
        if (instance == null) {
            instance = new NurseService();
        }
        return instance;
    }


    public void readNurses(DatabaseConnection connection, World world) {
        String selectStatement = "SELECT * FROM nurses;";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectStatement)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                Integer age = result.getInt("age");
                Integer yearsOfExperience = result.getInt("years");
                Integer salary = result.getInt("salary");
                String hospital = result.getString("hospital");
                String country = result.getString("country");

                Nurse nurse = new Nurse(yearsOfExperience, salary, name, age);
                world.getCountry(country).getHospital(hospital).addNurse((nurse));
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to read the nurse list.");
        }
    }

    public void addNurse(DatabaseConnection connection, World world, Nurse nurse, String hospitalName, String countryName) {
        String insertStatement = "INSERT into nurses values (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(insertStatement)) {
            statement.setInt(1, idNumber);
            statement.setString(2, nurse.getPersonName());
            statement.setInt(3, nurse.getAge());
            statement.setInt(4, nurse.getYearsOfExperience());
            statement.setInt(5, nurse.getSalary());
            statement.setString(6, hospitalName);
            statement.setString(7, countryName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                world.getCountry(countryName).getHospital(hospitalName).addNurse(nurse);
                System.out.println("A new nurse was inserted successfully!");
                idNumber += 1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to insert a new nurse: " + e.getMessage());
        }
    }
}

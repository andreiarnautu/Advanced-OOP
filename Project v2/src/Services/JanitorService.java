package Services;

import Entities.Doctor;
import Entities.Hospital;
import Entities.Janitor;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import javax.xml.crypto.Data;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JanitorService {
    public static JanitorService instance = null;
    public static int idNumber = 1;


    private JanitorService() {

    }


    public static JanitorService getInstance() {
        if (instance == null) {
            instance = new JanitorService();
        }
        return instance;
    }

    public void readJanitors(DatabaseConnection connection, World world) {
        String selectStatement = "SELECT * FROM janitors;";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectStatement)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                Integer age = result.getInt("age");
                Integer workShift = result.getInt("shift");
                Integer salary = result.getInt("salary");
                String hospital = result.getString("hospital");
                String country = result.getString("country");

                Janitor janitor = new Janitor(workShift, salary, name, age);
                world.getCountry(country).getHospital(hospital).addJanitor(janitor);
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to read the janitor list.");
        }
    }

    public void addJanitor(DatabaseConnection connection, World world, Janitor janitor, String hospitalName, String countryName) {
        String insertStatement = "INSERT into doctors values (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(insertStatement)) {
            statement.setInt(1, idNumber);
            statement.setString(2, janitor.getPersonName());
            statement.setInt(3, janitor.getAge());
            statement.setInt(4, janitor.getWorkShift());
            statement.setInt(5, janitor.getSalary());
            statement.setString(6, hospitalName);
            statement.setString(7, countryName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                world.getCountry(countryName).getHospital(hospitalName).addJanitor(janitor);
                System.out.println("A new janitor was inserted successfully!");
                idNumber += 1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to insert a new janitor: " + e.getMessage());
        }
    }
}

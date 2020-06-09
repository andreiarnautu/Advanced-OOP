package Services;

import Entities.Hospital;
import Entities.Patient;
import Entities.Victim;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class VictimService {
    public static VictimService instance = null;
    public static int idNumber = 1;

    private VictimService() {

    }


    public static VictimService getInstance() {
        if (instance == null) {
            instance = new VictimService();
        }
        return instance;
    }

    public void readVictims(DatabaseConnection connection, World world) {
        String selectStatement = "SELECT * FROM victims;";
        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(selectStatement)) {
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String name = result.getString("name");
                Integer age = result.getInt("age");
                String causeOfDeath = result.getString("cause");
                String hospital = result.getString("hospital");
                String country = result.getString("country");

                Victim victim = new Victim(causeOfDeath, name, age);
                world.getCountry(country).getHospital(hospital).addVictim(victim);
            }


        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to read the victims list.");
        }
    }


    public void writeVictims(World world, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write("Name,Age,Cause of death,Hospital,Country\n");

        for (Country country : world.getCountries()) {
            for (Hospital hospital : country.getHospitals()) {
                for (Victim victim : hospital.getListOfVictims()) {
                    writer.write(victim.getPersonName() + "," + victim.getAge() + "," +
                            victim.getCauseOfDeath() + "," + hospital.getHospitalName() + "," +
                            country.getCountryName() + "\n");
                }
            }
        }

        writer.close();
    }

    public void addVictim(DatabaseConnection connection, World world, Victim victim, String hospitalName, String countryName) {
        String insertStatement = "INSERT into victims values (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = DatabaseConnection.getInstance().getConnection().prepareStatement(insertStatement)) {
            statement.setInt(1, idNumber);
            statement.setString(2, victim.getPersonName());
            statement.setInt(3, victim.getAge());
            statement.setString(4, victim.getCauseOfDeath());
            statement.setString(5, hospitalName);
            statement.setString(6, countryName);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                world.getCountry(countryName).getHospital(hospitalName).addVictim(victim);
                System.out.println("A new victim was inserted successfully!");
                idNumber += 1;
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Something went wrong when trying to insert a new victim: " + e.getMessage());
        }
    }
}

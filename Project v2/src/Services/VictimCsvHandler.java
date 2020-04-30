package Services;

import Entities.Hospital;
import Entities.Patient;
import Entities.Victim;

import java.io.*;
import java.util.Scanner;

public class VictimCsvHandler {
    public static VictimCsvHandler instance = null;


    private VictimCsvHandler() {

    }


    public static VictimCsvHandler getInstance() {
        if (instance == null) {
            instance = new VictimCsvHandler();
        }
        return instance;
    }


    public void readVictims(World world, String filePath) throws FileNotFoundException {
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
            String causeOfDeath = data[2];
            String hospital = data[3];
            String country = data[4];

            Victim victim = new Victim(causeOfDeath, name, age);
            world.getCountry(country).getHospital(hospital).addVictim(victim);
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
}

import javax.sound.midi.Soundbank;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        World world = new World();  //  This shit is fucking poetic

        //  Let's make a few object instances, shall we
        Nurse nurse1 = new Nurse(2, 5000, "Violet", 26);
        Nurse nurse2 = new Nurse(10, 8500, "Gwen", 37);

        Janitor janitor1 = new Janitor(1, 2000, "John Keynes",64);
        Janitor janitor2 =  new Janitor(2, 2300, "Alex Jones", 56);
        Janitor janitor3 = new Janitor(3, 3600, "Bobby Miles", 48);

        Doctor doctor1 = new Doctor("cardiology", 18500, 3487, "Richard Nix", 39);
        Doctor doctor2 = new Doctor("neurology", 26800, 1287, "Capris Ruth", 33);
        Doctor doctor3 = new Doctor("anesthetology", 14000, 4062, "Jack Henderson", 40);

        Victim victim1 = new Victim("covid-19", "Jane Doe", 66);
        Victim victim2 = new Victim("covid-19", "John Doe", 74);

        Pacient pacient1 = new Pacient("Robert Brown", 80, 7);
        pacient1.addDisease("covid-19");
        pacient1.addDisease("diabetes");

        Pacient pacient2 = new Pacient("Eva Lolley", 69, 12);
        pacient2.addDisease("asthma");
        pacient2.addDisease("covid-19");

        Hospital hospital1 = new Hospital("London Central Hospital");
        Hospital hospital2 = new Hospital("Manchester Hospital");
        Hospital hospital3 = new Hospital("Grey-Sloan Memorial Hospital");

        Country country1 = new Country("England");
        Country country2 = new Country("USA");

        hospital1.addNurse(nurse1);
        hospital1.addJanitor(janitor1);
        hospital1.addJanitor(janitor2);
        hospital1.addDoctor(doctor1);
        hospital1.addVictim(victim1);

        hospital2.addNurse(nurse2);
        hospital2.addJanitor(janitor3);
        hospital2.addDoctor(doctor2);
        hospital2.addDoctor(doctor3);
        hospital2.addVictim(victim2);
        hospital2.addPacient(pacient1);
        hospital2.addPacient(pacient2);

        country1.addHospital(hospital1);
        country1.addHospital(hospital2);
        country2.addHospital(hospital3);

        world.addCountry(country1);
        world.addCountry(country2);

        world.printCountries();

        System.out.println("List of most common diseases at the Manchester Hospital is:");
        TreeSet<String> diseaseList = world.getCountry("England").getHospital("Manchester Hospital").getListOfDiseases();
        for (String disease : diseaseList) {
            System.out.println(disease);
        }

        System.out.println("The most common disease at the Manchester Hospital is:");
        System.out.println(world.getCountry("England").getHospital("Manchester Hospital").getMostCommonDisease());

        System.out.println("The employees working at the London Central Hospital are:");
        world.getCountry("England").getHospital("London Central Hospital").printHospitalEmployees();

        System.out.println("The sum of the salaries at London Central Hospital: " + world.getCountry("England").getHospital("London Central Hospital").getSumOfSalaries());
    }
}

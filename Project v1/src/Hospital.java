import javax.print.Doc;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Hospital {
    private String hospitalName;
    private ArrayList<Pacient> listOfPacients;  //  pacients currently being treated
    private ArrayList<Victim> listOfVictims;  //  pacients who have sadly died
    private ArrayList<Doctor> listOfDoctors;
    private ArrayList<Nurse> listOfNurses;
    private ArrayList<Janitor> listOfJanitors;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        listOfPacients = new ArrayList<>();
        listOfVictims = new ArrayList<>();
        listOfDoctors = new ArrayList<>();
        listOfNurses = new ArrayList<>();
        listOfJanitors = new ArrayList<>();
    }

    //  Getters and setters
    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    //  Add operations
    public void addPacient(Pacient pacient) {
        this.listOfPacients.add(pacient);
    }

    public void addVictim(Victim victim) {
        this.listOfVictims.add(victim);
    }

    public void addDoctor(Doctor doctor) {
        this.listOfDoctors.add(doctor);
    }

    public void addNurse(Nurse nurse) {
        this.listOfNurses.add(nurse);
    }

    public void addJanitor(Janitor janitor) {
        this.listOfJanitors.add(janitor);
    }

    //  Query sizes
    public Integer getNumberOfPacients() {
        return this.listOfPacients.size();
    }

    public Integer getNumberOfVictims() {
        return this.listOfVictims.size();
    }

    public Integer getNumberOfDoctors() {
        return this.listOfDoctors.size();
    }

    public Integer getNumberOfNurses() {
        return this.listOfNurses.size();
    }

    public Integer getNumberOfJanitors() {
        return this.listOfJanitors.size();
    }

    public Integer getNumberOfEmployees() {
        return this.getNumberOfDoctors() + this.getNumberOfNurses() + this.getNumberOfJanitors();
    }

    //  Print operations
    public void printListOfPacients() {
        System.out.println("List of checked-in pacients at hospital " + this.hospitalName + ":");
        for (Pacient pacient : this.listOfPacients) {
            System.out.println(pacient.getData());
        }
    }

    public void printListOfVictims() {
        System.out.println("List of registered victims at hospital " + this.hospitalName + ":");
        for (Victim victim : this.listOfVictims) {
            System.out.println(victim.getData());
        }
    }

    public void printListOfDoctors() {
        System.out.println("List of employed doctors at hospital " + this.hospitalName + ":");
        for (Doctor doctor : this.listOfDoctors) {
            System.out.println(doctor.getData());
        }
    }

    public void printListOfNurses() {
        System.out.println("List of employed nurses at hospital " + this.hospitalName + ":");
        for (Nurse nurse : this.listOfNurses) {
            System.out.println(nurse.getData());
        }
    }

    public void printListOfJanitors() {
        System.out.println("List of employed janitors at hospital " + this.hospitalName + ":");
        for (Janitor janitor : this.listOfJanitors) {
            System.out.println(janitor.getData());
        }
    }

    public void printHospitalEmployees() {
        System.out.println(String.format("Printing the %d employees of hospital %s", this.getNumberOfEmployees(), this.hospitalName));
        this.printListOfDoctors();
        this.printListOfNurses();
        this.printListOfJanitors();
    }

    //  Other queries

    //  Get all the diseases that are currently present in the current hospital
    public TreeSet<String> getListOfDiseases() {
        TreeSet<String> diseaseList = new TreeSet<>();

        for (Pacient pacient : this.listOfPacients) {
            diseaseList.addAll(pacient.getListOfDiseases());
        }

        return diseaseList;
    }

    public String getMostCommonDisease() {
        String mostCommonDisease = "";
        Integer mostAppearances = 0;
        Map<String, Integer> appearanceMap = new HashMap<>();

        for (Pacient pacient : this.listOfPacients) {
            for (String disease : pacient.getListOfDiseases()) {
                if (appearanceMap.containsKey(disease)) {
                    appearanceMap.replace(disease, appearanceMap.get(disease) + 1);
                } else {
                    appearanceMap.put(disease, 1);
                }

                if (mostAppearances < appearanceMap.get(disease)) {
                    mostAppearances = appearanceMap.get(disease);
                    mostCommonDisease = disease;
                }
            }
        }

        return mostCommonDisease;
    }

    public Integer getSumOfSalaries() {
        Integer result = 0;
        for (Doctor doctor : this.listOfDoctors) {
            result += doctor.getSalary();
        }
        for (Nurse nurse : this.listOfNurses) {
            result += nurse.getSalary();
        }
        for (Janitor janitor : this.listOfJanitors) {
            result += janitor.getSalary();
        }

        return result;
    }
}

package Entities;

import Services.AuditHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Hospital {
    private String countryName;
    private String hospitalName;
    private ArrayList<Patient> listOfPatients;  //  pacients currently being treated
    private ArrayList<Victim> listOfVictims;  //  pacients who have sadly died
    private ArrayList<Doctor> listOfDoctors;
    private ArrayList<Nurse> listOfNurses;
    private ArrayList<Janitor> listOfJanitors;

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        listOfPatients = new ArrayList<>();
        listOfVictims = new ArrayList<>();
        listOfDoctors = new ArrayList<>();
        listOfNurses = new ArrayList<>();
        listOfJanitors = new ArrayList<>();
    }

    //  Getters and setters

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public ArrayList<Patient> getListOfPatients() {
        return listOfPatients;
    }

    public ArrayList<Victim> getListOfVictims() {
        return listOfVictims;
    }

    public ArrayList<Doctor> getListOfDoctors() {
        return listOfDoctors;
    }

    public ArrayList<Nurse> getListOfNurses() {
        return listOfNurses;
    }

    public ArrayList<Janitor> getListOfJanitors() {
        return listOfJanitors;
    }

    //  Add operations
    public void addPatient(Patient patient) {
        this.listOfPatients.add(patient);
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
    public Integer getNumberOfPacients() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfPacients()");
        return this.listOfPatients.size();
    }

    public Integer getNumberOfVictims() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfVictims()");
        return this.listOfVictims.size();
    }

    public Integer getNumberOfDoctors() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfDoctors()");
        return this.listOfDoctors.size();
    }

    public Integer getNumberOfNurses() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfNurses()");
        return this.listOfNurses.size();
    }

    public Integer getNumberOfJanitors() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfJanitors()");
        return this.listOfJanitors.size();
    }

    public Integer getNumberOfEmployees() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getNumberOfEmployees()");
        return this.getNumberOfDoctors() + this.getNumberOfNurses() + this.getNumberOfJanitors();
    }

    //  Print operations
    public void printListOfPacients() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfPacients()");

        System.out.println("List of checked-in pacients at hospital " + this.hospitalName + ":");
        for (Patient pacient : this.listOfPatients) {
            System.out.println(pacient.getData());
        }
    }

    public void printListOfVictims() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfVictims()");

        System.out.println("List of registered victims at hospital " + this.hospitalName + ":");
        for (Victim victim : this.listOfVictims) {
            System.out.println(victim.getData());
        }
    }

    public void printListOfDoctors() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfDoctors()");

        System.out.println("List of employed doctors at hospital " + this.hospitalName + ":");
        for (Doctor doctor : this.listOfDoctors) {
            System.out.println(doctor.getData());
        }
    }

    public void printListOfNurses() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfNurses()");

        System.out.println("List of employed nurses at hospital " + this.hospitalName + ":");
        for (Nurse nurse : this.listOfNurses) {
            System.out.println(nurse.getData());
        }
    }

    public void printListOfJanitors() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfJanitors()");

        System.out.println("List of employed janitors at hospital " + this.hospitalName + ":");
        for (Janitor janitor : this.listOfJanitors) {
            System.out.println(janitor.getData());
        }
    }

    public void printHospitalEmployees() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printHospitalEmployees()");

        System.out.println(String.format("Printing the %d employees of hospital %s", this.getNumberOfEmployees(), this.hospitalName));
        this.printListOfDoctors();
        this.printListOfNurses();
        this.printListOfJanitors();
    }

    //  Other queries

    //  Get all the diseases that are currently present in the current hospital
    public TreeSet<String> getListOfDiseases() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").printListOfDiseases()");

        TreeSet<String> diseaseList = new TreeSet<>();

        for (Patient pacient : this.listOfPatients) {
            diseaseList.addAll(pacient.getListOfDiseases());
        }

        return diseaseList;
    }

    public String getMostCommonDisease() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getMostCommonDisease()");

        String mostCommonDisease = "";
        Integer mostAppearances = 0;
        Map<String, Integer> appearanceMap = new HashMap<>();

        for (Patient pacient : this.listOfPatients) {
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

    public Integer getSumOfSalaries() throws IOException {
        AuditHandler.printAction("Hospital(" + this.hospitalName + ").getSumOfSalaries()");
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

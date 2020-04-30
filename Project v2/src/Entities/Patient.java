package Entities;

import java.util.ArrayList;

public class Patient extends Person {
    private Integer timeSinceHospitalization;
    private ArrayList<String> listOfDiseases;

    Patient() {
        super();
        timeSinceHospitalization = 0;
        listOfDiseases = new ArrayList<>();
    }

    public Patient(String patientName, Integer age, Integer timeSinceHospitalization) {
        super(patientName, age);
        this.listOfDiseases = new ArrayList<>();
        this.timeSinceHospitalization = timeSinceHospitalization;
    }

    public Integer getTimeSinceHospitalization() {
        return timeSinceHospitalization;
    }

    public void setTimeSinceHospitalization(Integer timeSinceHospitalization) {
        this.timeSinceHospitalization = timeSinceHospitalization;
    }

    public void addDisease(String diseaseName) {
        this.listOfDiseases.add(diseaseName);
    }

    public ArrayList<String> getListOfDiseases() {
        return this.listOfDiseases;
    }
}

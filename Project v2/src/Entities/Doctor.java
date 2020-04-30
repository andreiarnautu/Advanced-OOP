package Entities;

public class Doctor extends Person {
    private String areaOfExpertise;
    private Integer salary;
    private Integer patientsTreated;

    public Doctor(String areaOfExpertise, Integer salary, Integer patientsTreated, String doctorName, Integer age) {
        super(doctorName, age);
        this.salary = salary;
        this.areaOfExpertise = areaOfExpertise;
        this.patientsTreated = patientsTreated;
    }

    public String getAreaOfExpertise() {
        return areaOfExpertise;
    }

    public void setAreaOfExpertise(String areaOfExpertise) {
        this.areaOfExpertise = areaOfExpertise;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getPatientsTreated() {
        return patientsTreated;
    }

    public void setPatientsTreated(Integer patientsTreated) {
        this.patientsTreated = patientsTreated;
    }
}

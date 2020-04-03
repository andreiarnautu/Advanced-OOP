public class Doctor extends Person {
    private String areaOfExpertise;
    private Integer salary;
    private Integer pacientsTreated;

    public Doctor(String areaOfExpertise, Integer salary, Integer pacientsTreated, String doctorName, Integer age) {
        super(doctorName, age);
        this.salary = salary;
        this.areaOfExpertise = areaOfExpertise;
        this.pacientsTreated = pacientsTreated;
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

    public Integer getPacientsTreated() {
        return pacientsTreated;
    }

    public void setPacientsTreated(Integer pacientsTreated) {
        this.pacientsTreated = pacientsTreated;
    }
}

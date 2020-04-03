public class Nurse extends Person {
    private Integer yearsOfExperience;
    private Integer salary;

    public Nurse(Integer yearsOfExperience, Integer salary, String nurseName, Integer age) {
        super(nurseName, age);
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

package Entities;

public class Janitor extends Person {
    Integer workShift;
    Integer salary;

    public Janitor(Integer workShift, Integer salary, String janitorName, Integer age) {
        super(janitorName, age);
        this.salary = salary;
        if (1 <= workShift && workShift <= 3) {
            this.workShift = workShift;
        } else {
            this.workShift = 0;
        }
    }

    public Integer getWorkShift() {
        return workShift;
    }

    public void setWorkShift(Integer workShift) {
        this.workShift = workShift;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}

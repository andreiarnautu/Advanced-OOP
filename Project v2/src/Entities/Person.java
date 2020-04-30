package Entities;

public class Person {
    protected String personName;
    protected Integer age;

    public Person() {
        personName = "";
        age = 0;
    }

    public Person(String personName, Integer age) {
        this.personName = personName;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    //  Return the basic info about a person in string format
    public String getData() {
        return String.format("%s, age %d", this.personName, this.age);
    }
}

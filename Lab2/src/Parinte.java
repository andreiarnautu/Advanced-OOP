public class Parinte {
    private String name;
    protected int age;

    public Parinte() {
        this.name = "";
        this.age = 0;
    }

    public Parinte(String name) {
        this.name = name;
    }

    public Parinte(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void printData() {
        System.out.println("Persoana " + this.name + " are varsta " + this.age + ".");
    }
}

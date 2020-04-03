import java.util.ArrayList;

public class Pacient extends Person {
    private Integer timeSinceHospitalization;
    private ArrayList<String> listOfDiseases;

    Pacient() {
        super();
        timeSinceHospitalization = 0;
        listOfDiseases = new ArrayList<>();
    }

    public Pacient(String pacientName, Integer age, Integer timeSinceHospitalization) {
        super();
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

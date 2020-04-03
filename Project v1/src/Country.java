import java.util.TreeSet;

public class Country {
    private String countryName;
    TreeSet<Hospital> hospitals;

    public Country(String countryName) {
        this.countryName = countryName;
        hospitals = new TreeSet<Hospital>(new HospitalComparator());
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void addHospital(Hospital hospital) {
        hospitals.add(hospital);
    }

    public TreeSet<Hospital> getHospitals() {
        return this.hospitals;
    }

    public Hospital getHospital(String hospitalName) {
        Hospital result = null;

        for (Hospital hospital : hospitals) {
            if (hospital.getHospitalName().equals(hospitalName)) {
                result = hospital;
                break;
            }
        }

        return result;
    }
}

import java.util.Comparator;

public class HospitalComparator implements Comparator<Hospital> {
    public int compare(Hospital a, Hospital b) {
        return a.getHospitalName().compareTo(b.getHospitalName());
    }
}

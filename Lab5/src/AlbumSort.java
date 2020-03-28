import java.util.Comparator;

//  Sortam descrescator dupa note si in caz de egalitate, crescator lexicografic.
public class AlbumSort implements Comparator<Album> {
    public int compare(Album a, Album b) {
        if (a.rating != b.rating) {
            return b.rating - a.rating;
        }
        return a.name.compareTo(b.name);
    }
}

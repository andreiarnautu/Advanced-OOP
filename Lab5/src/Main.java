import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/*
 *  Worg
 */
public class Main {
    public static void main(String[] args) {
        TestEx2();
    }

    public static void TestEx2() {
        ArrayList<Album> albumList = new ArrayList<>();

        albumList.add(new Album("Ceva album Taylor Swift", 2015, 2));
        albumList.add(new Album("Trilogy", 2012, 10));
        albumList.add(new Album("Beauty behind the Madness", 2015, 10));
        albumList.add(new Album("After Hours", 2020, 11));

        System.out.println("Unsorted list:");
        int id;
        id = 1;
        for (Album album : albumList) {
            System.out.println(String.format("%d. ", id) + album.name + " --- " + String.format("Year: %d --- Rating: %d", album.publicationYear, album.rating));
            id++;
        }

        Collections.sort(albumList, new AlbumSort());

        System.out.println("Sorted:");
        id = 1;
        for (Album album : albumList) {
            System.out.println(String.format("%d. ", id) + album.name + " --- " + String.format("Year: %d --- Rating: %d", album.publicationYear, album.rating));
            id++;
        }


    }

    public static void TestEx1() {
        OutTask a = new OutTask();
        RandomOutTask b = new RandomOutTask();
        CounterOutTask c = new CounterOutTask();

        a.execute();
        b.execute();
        c.execute();
        c.execute();
        c.execute();
        b.execute();
        a.execute();
    }
}

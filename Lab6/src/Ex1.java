import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex1 {
    public void run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter(new File("ex1.out"));

        int pairsToRead = 3;
        while (pairsToRead > 0) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            try {
                if (x > y) {
                    throw new ValueException("First number is bigger than the second one. Please insert another pair.");
                }
            } catch (ValueException e) {
                System.out.println(e.getMessage());
                continue;
            }

            writer.write(x + " " + y + "\n");
            pairsToRead -= 1;
        }

        writer.close();
    }
}

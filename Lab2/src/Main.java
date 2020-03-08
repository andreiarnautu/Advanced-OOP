import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
  *  Worg
  */
public class Main {

    public static void main(String[] args) {
        Scanner fin = new Scanner(System.in);
        int[] newArray = new int[50];
        String[] stringArray = new String[100];  //  Referinta catre o adresa in memorie unde se afla valorile noastre.

        taskFour(fin);
    }

    public static void testOne() {
        int[] myArray = new int[50];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i;
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
    }

    public static void taskOne(Scanner fin) {
        float elementSum = 0;
        int elementCount = 0;

        while (true) {
            int x;
            x = fin.nextInt();

            if (x != -1) {
                elementSum += x;
                elementCount += 1;
            } else {
                break;
            }
        }

        if (elementCount > 0) {
            System.out.println(elementSum / elementCount);
        } else {
            System.out.println("No numbers, no cry.");
        }
    }

    public static void taskTwo(Scanner fin) {
        List<Integer> listEven = new ArrayList<Integer>();
        List<Integer> listOdd = new ArrayList<Integer>();
        int n;
        n = fin.nextInt();

        for (int i = 0; i < n; i++) {
            int x;
            x = fin.nextInt();

            if (x % 2 == 0) {
                listEven.add(x);
            } else {
                listOdd.add(x);
            }
        }

        Integer[] arrEven = new Integer[listEven.size()];
        Integer[] arrOdd = new Integer[listOdd.size()];
        listEven.toArray(arrEven);
        listOdd.toArray(arrOdd);

        System.out.println("Sirul cu numerele pare:");
        for (int i = 0; i < arrEven.length; i++) {
            System.out.print(arrEven[i] + " ");
        }
        System.out.println("\nSirul cu numerele impare:");
        for (int i = 0; i < arrOdd.length; i++) {
            System.out.print(arrOdd[i] + " ");
        }
        System.out.println();
    }

    public static void taskThree(Scanner fin) {
        Parinte parinte = new Parinte();
        parinte.setAge(50);
        parinte.setName("Florin");

        System.out.println(parinte.getName());
        System.out.println(parinte.getAge());
        parinte.printData();
    }

    public static void taskFour(Scanner fin) {
        int n = fin.nextInt();
        Student[] studentArr = new Student[n];

        fin.nextLine();
        for (int i = 0; i < n; i++) {
            studentArr[i] = new Student();
            String line = fin.nextLine();
            String[] params = line.split(" ");

            studentArr[i].setMark(Integer.parseInt(params[1]));
            studentArr[i].setName(params[0]);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(studentArr[i].getName() + " " + studentArr[i].getMark());
        }
    }
}

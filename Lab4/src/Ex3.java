import java.util.Scanner;

public class Ex3 {
    public void getTotalPrimes() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Integer[][] matrix = new Integer[n][m];
        Integer[][] result = new Integer[n][m];
        int countOnes = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();

                if (isPrime(matrix[i][j])) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = 1;
                    countOnes += 1;
                }
            }
        }

        System.out.println(countOnes);
    }

    public boolean isPrime(Integer x) {
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

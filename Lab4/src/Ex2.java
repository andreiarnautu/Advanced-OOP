import java.util.Scanner;

public class Ex2 {

    public void solveSecondTask() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        String[] stringArray = new String[n];
        int countPalindromes = 0;
        for (int i = 0; i < n; i++) {
            stringArray[i] = scanner.nextLine();
            if (checkPalindrome(stringArray[i]) != -1) {
                countPalindromes += 1;
            }
        }

        String[] palindromes = new String[countPalindromes];
        String longestPalindrome = "";
        int biggestSize = -1;

        for (int i = 0, palindrome_id = 0; i < n; i++) {
            Integer verdict = checkPalindrome(stringArray[i]);

            if (verdict != -1) {
                palindromes[palindrome_id] = stringArray[i];
                palindrome_id += 1;

                if (biggestSize < stringArray[i].length()) {
                    biggestSize = stringArray[i].length();
                    longestPalindrome = stringArray[i];
                }
            }
        }

        if (!longestPalindrome.equals("")) {
            System.out.println(longestPalindrome);
        } else {
            System.out.println("There are no palindromes.");
        }

    }

    public Integer checkPalindrome(String s) {
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != s.charAt(size - 1 - i)) {
                return -1;
            }
        }
        return size;
    }
}

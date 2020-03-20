/**
  *  Worg
  */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//  Function that solves the first task
public class Ex1 {
    public boolean checkAnagrams() {
        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.nextLine();
        String secondString = scanner.nextLine();

        //  Check if they have the same length.
        if (firstString.length() != secondString.length()) {
            return false;
        }

        //  Check if they have the same characters.
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < firstString.length(); i++) {
            String ch = firstString.substring(i, i + 1);
            if (hashMap.containsKey(ch)) {
                hashMap.replace(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        for (int i = 0; i < secondString.length(); i++) {
            String ch = secondString.substring(i, i + 1);
            if (!hashMap.containsKey(ch)) {
                return false;
            }
            if (hashMap.get(ch) > 1) {
                hashMap.replace(ch, hashMap.get(ch) - 1);
            }
        }
        return true;
    }
}

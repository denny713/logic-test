import java.util.*;

public class AlmostAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        scanner.close();

        Map<String, Integer> almostAnagramCounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word1 = words[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && isAlmostAnagram(word1, words[j])) {
                    count++;
                }
            }
            almostAnagramCounts.put(word1, count);
        }

        for (String word : words) {
            System.out.println(word + " " + almostAnagramCounts.get(word));
        }
    }

    private static boolean isAlmostAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
            }
            if (diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }
}

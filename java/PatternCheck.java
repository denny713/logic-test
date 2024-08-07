public class PatternCheck {
    public static boolean checkPattern(String input) {
        // Memeriksa apakah panjang string adalah 6
        if (input.length() != 6) {
            return false;
        }

        // Memeriksa apakah semua karakter string sama
        char firstChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) != firstChar) {
                return false;
            }
        }

        // Memeriksa apakah semua karakter string berurutan
        boolean isSequential = true;
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i + 1) != input.charAt(i) + 1) {
                isSequential = false;
                break;
            }
        }

        return !isSequential;
    }

    public static void main(String[] args) {
        String[] patterns = {"111111", "123123", "121212", "112233"};
        for (String pattern : patterns) {
            System.out.println(pattern + ": " + checkPattern(pattern));
        }
    }
}

public class VowelCheck {
    public static void main(String[] args) {
        char[] characters = {'a', 'b', 'e', 'F', 'i', 'O', 'z'}; 
        
        checkVowels(characters);
    }

    public static void checkVowels(char[] characters) {
        for (char ch : characters) {
            if (isVowel(ch)) {
                System.out.println(ch + " adalah huruf vokal.");
            } else {
                System.out.println(ch + " adalah huruf bukan vokal.");
            }
        }
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}

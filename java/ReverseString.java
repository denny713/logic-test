public class ReverseString {
    public static String reverse(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        char[] characters = s.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;

            left++;
            right--;
        }

        return new String(characters);
    }

    public static void main(String[] args) {
        String str = "denny afrizal";
        System.out.println(reverse(str));
    }
}

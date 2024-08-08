public class OddEven {
    public static void main(String[] args) {
        int[] numbers = {10, 15, 20, 25, 30};
        
        checkOddEven(numbers);
    }

    public static void checkOddEven(int[] numbers) {
        for (int number : numbers) {
            if (isEven(number)) {
                System.out.println(number + " adalah bilangan genap.");
            } else {
                System.out.println(number + " adalah bilangan ganjil.");
            }
        }
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}

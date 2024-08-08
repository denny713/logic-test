public class PrintAsterix {
    public static void main(String[] args) {
        int limit = 7;
        descAsterix(limit);
        System.out.println(" ");
        ascAsterix(limit);
    }

    public static void descAsterix(int limit) {
        for (int i = limit; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void ascAsterix(int limit) {
        for (int i = 1; i <= limit; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

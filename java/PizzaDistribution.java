public class PizzaDistribution {

    public static int calculateMaxPizzaPerChild(int totalPizza, int totalChildren) {
        int maxPizzaPerChild = totalPizza / totalChildren;
        int remainingPizza = totalPizza % totalChildren;

        System.out.println("Setiap anak dapat makan " + maxPizzaPerChild + " potong pizza.");
        System.out.println("Ada " + remainingPizza + " potong pizza yang tersisa setelah pembagian rata.");

        return maxPizzaPerChild;
    }

    public static void distributePizza(int totalPizza, int totalChildren) {
        int maxPizzaPerChild = calculateMaxPizzaPerChild(totalPizza, totalChildren);

        int[] pizzaEaten = new int[totalChildren];
        int pizzaLeft = totalPizza;

        for (int i = 0; i < totalChildren; i++) {
            pizzaEaten[i] = maxPizzaPerChild;
            pizzaLeft -= maxPizzaPerChild;

            System.out.println("Anak " + (i + 1) + " makan " + pizzaEaten[i] + " potong pizza.");
        }

        if (pizzaLeft > 0) {
            System.out.println("Sisa " + pizzaLeft + " potong pizza yang tidak termakan.");
        } else {
            System.out.println("Semua pizza telah habis dimakan.");
        }
    }

    public static void main(String[] args) {
        int totalPizza = 10;
        int totalChildren = 3;

        distributePizza(totalPizza, totalChildren);
    }
}

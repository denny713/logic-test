import java.util.ArrayList;

public class PrimeValue {

    public static void main(String[] args) {
        int limit = 100;
        ArrayList<Integer> primeDesc = generatePrimesDescending(limit);
        ArrayList<Integer> primeAsc = generatePrimesAscending(limit);
        
        System.out.println("Ascending Primes");
        for (int prime : primeAsc) {
            System.out.println(prime);
        }

        System.out.println("Descending Primes");
        for (int prime : primeDesc) {
            System.out.println(prime);
        }
    }

    public static ArrayList<Integer> generatePrimesDescending(int limit) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = limit; i >= 2; i--) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static ArrayList<Integer> generatePrimesAscending(int limit) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

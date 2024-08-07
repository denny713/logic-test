import java.util.PriorityQueue;

public class JesseAndCookies {
    public static int cookies(int k, int[] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int sweetness : A) {
            minHeap.add(sweetness);
        }

        int operations = 0;

        while (minHeap.size() > 1 && minHeap.peek() < k) {
            int leastSweet = minHeap.poll();
            int secondLeastSweet = minHeap.poll();

            int newCookie = leastSweet + 2 * secondLeastSweet;
            minHeap.add(newCookie);
            operations++;
        }

        return minHeap.peek() >= k ? operations : -1;
    }

    public static void main(String[] args) {
        int k = 9;
        int[] A = {1, 2, 3, 9, 10, 12};
        int result = cookies(k, A);
        System.out.println(result);
    }
}

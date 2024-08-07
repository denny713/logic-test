public class MissingNumber {
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int total = n * (n + 1) / 2;
        for (int num : nums) {
            total -= num;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(findMissingNumber(nums));
    }
}

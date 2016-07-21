package exercises.TimeComplexity.TapeEquilibrium;

public class Solution {
    public static void main(String[] args) {
        int p = new Solution().run(new int[] { 3, 1, 2, 4, 3 });
        System.out.println(p);
    }

    private int[] calculateSum(int[] array, boolean reverse) {
        int[] sums = new int[array.length];
        if (reverse) {
            int sum = sums[sums.length - 1] = array[array.length - 1];
            for (int i = sums.length - 2; i >= 0; i--) {
                sums[i] = (sum += array[i]);
            }
        } else {
            int sum = sums[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                sums[i] = (sum += array[i]);
            }
        }
        return sums;
    }

    private int run(int[] A) {
        int[] rtlSums = calculateSum(A, false);
        int[] ltrSums = calculateSum(A, true);
        int minDifference = Math.abs(rtlSums[0] - ltrSums[1]);
        int diff;
        for (int i = 2; i < ltrSums.length; i++) {
            diff = Math.abs(rtlSums[i - 1] - ltrSums[i]);
            if (minDifference > diff) {
                minDifference = diff;
            }
        }
        return minDifference;
    }
}
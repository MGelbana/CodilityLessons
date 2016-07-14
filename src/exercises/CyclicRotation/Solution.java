package exercises.CyclicRotation;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        new Solution().start();
    }

    private void start() {
        int[] A = new int[] { 1, 2, 3, 4, 5 };
        int[] original = Arrays.copyOf(A, A.length);
        A = solution(A, 5);
        System.out.println(String.format("Solution for: %s is %s", Arrays.toString(original), Arrays.toString(A)));
    }

    private int[] solution(int[] A, int K) {
        if (A == null || A.length == 0 || A.length == 1 || A.length == K) {
            return A;
        }
        if (K > A.length) {
            K = K % A.length;
        }
        int[] leftArray = Arrays.copyOfRange(A, A.length - K, A.length);
        int[] rightArray = Arrays.copyOfRange(A, 0, A.length - K);
        for (int i = 0; i < rightArray.length; i++) {
            A[A.length - (rightArray.length - i)] = rightArray[i];
        }
        for (int i = 0; i < leftArray.length; i++) {
            A[i] = leftArray[i];
        }
        return A;
    }
    // private void solution(int[] array, int rotations) {
    // int temp, swappedPosition;
    // int[] original = Arrays.copyOf(array, array.length);
    // for (int i = 0; i < rotations; i++) {
    // swappedPosition = array.length - (rotations - i);
    // temp = array[i];
    // array[i] = array[swappedPosition];
    // array[swappedPosition] = temp;
    // }
    // System.out.println(String.format("Solution for: %s is %s", Arrays.toString(original), Arrays.toString(array)));
    // }
}

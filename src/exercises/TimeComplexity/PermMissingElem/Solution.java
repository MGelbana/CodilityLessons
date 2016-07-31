package exercises.TimeComplexity.PermMissingElem;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] { 3, 2, 5, 1 }));
    }

    private int solution(int[] A) {
        Set<Integer> pool = new HashSet<Integer>(A.length);
        pool.add(A.length + 1);
        for (int i = 0; i < A.length; i++) {
            if (pool.contains(i + 1)) {
                pool.remove(i + 1);
            } else {
                pool.add(i + 1);
            }
            if (pool.contains(A[i])) {
                pool.remove(A[i]);
            } else {
                pool.add(A[i]);
            }
        }
        return pool.iterator().next();
    }

    // A less efficient solution but still succeeds the O(N) test
    private int solution2(int[] A) {
        Set<Integer> pool = new HashSet<Integer>(A.length);
        for (int i = 1; i <= A.length + 1; i++) {
            pool.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            if (pool.contains(A[i])) {
                pool.remove(A[i]);
            } else {
                return A[i];
            }
        }
        return pool.iterator().next();
    }
}

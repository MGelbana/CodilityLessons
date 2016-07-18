package exercises.OddOccurrencesInArray;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] A) {
        Set<Integer> flags = new HashSet<>(A.length);
        for (int i = 0; i < A.length; i++) {
            if (flags.contains(A[i])) {
                flags.remove(A[i]);
            } else {
                flags.add(A[i]);
            }
        }
        return flags.iterator().next();
    }
}
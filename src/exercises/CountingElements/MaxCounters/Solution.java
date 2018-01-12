package exercises.CountingElements.MaxCounters;

public class Solution {
    public int[] solution(int N, int[] A) {
        int[] counters = new int[N];
        boolean[] modified = new boolean[N];
        int max = 0;
        int base = 0;
        int countersIndex;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) { // Max all
                modified = new boolean[N];
                base = max;
            } else { // Increment a single element by 1
                countersIndex = A[i] - 1;
                if (modified[countersIndex]) {
                    counters[countersIndex] = counters[countersIndex] + 1;
                } else {
                    modified[countersIndex] = true;
                    counters[countersIndex] = base + 1;
                }
                max = Math.max(counters[countersIndex], max);
            }
        }
        for (int i = 0; i < counters.length; i++) {
            if (!modified[i]) counters[i] = base;
        }
        return counters;
    }
}
package exercises.TimeComplexity.FrogJmp;

public class Solution {
    public static void main(String[] args) {
        new Solution().solution(0, 0, 0);
    }

    public int solution(int X, int Y, int D) {
        return (int) Math.ceil(((double) Y - (double) X) / (double) D);
    }
}

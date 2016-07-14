package tests.ShortestInclusiveRange;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    private static final Random r = new Random();
    private static final int N_LIMIT = 20;

    public static void main(String[] args) {
        // int[][] arrays = { { 1, 2, 3, 4, 5, 6, 6 } };
        // int[][] arrays = { { 1, 2, 3, 4, 5, 6, 6 }, { 7, 3, 7, 3, 1, 3, 4, 1 } };
        // int[][] arrays = { { 7, 3, 7, 3, 1, 3, 4, 1 } };
        long start, time;
        int[] array;
        // for (int i = 0; i < 10; i++) {
        // array = createArray();
        // start = System.nanoTime();
        // process(array);
        // time = System.nanoTime() - start;
        // System.out.println(String.format("Array size: %s, Time taken: %s ms (%s nanoseconds)", array.length, TimeUnit.NANOSECONDS.toMillis(time), time));
        // }
        // process(new int[] { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 });
        // process(new int[] { 2, 12, 19, 16, 3, 3 });
        process(new int[] { 7, 1, 4, 17, 9, 9, 3, 8, 13, 5, 7, 18, 1, 17, 17, 8, 12, 4 });
    }

    private static int[] createArray() {
        int n = r.nextInt(N_LIMIT);
        while (n == 0) {
            n = r.nextInt(N_LIMIT);
        }
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(N_LIMIT);
        }
        return array;
    }

    private static void process(int[] array) {
        System.out.print(String.format("Solution for: %s is: ", Arrays.toString(array)));
        Map<Integer, ValueInformation> repeatedValues = new HashMap<Integer, ValueInformation>(array.length);
        Map<Integer, ValueInformation> uniqueValues = new HashMap<Integer, ValueInformation>(array.length);
        for (int i = 0; i < array.length; i++) {
            Integer arrayValue = array[i];
            ValueInformation valueInformation = new ValueInformation(arrayValue, i);
            ValueInformation tempValueInformation = uniqueValues.get(arrayValue);
            if (tempValueInformation == null) {
                uniqueValues.put(arrayValue, valueInformation);
            } else {
                uniqueValues.remove(arrayValue);
                tempValueInformation.setLastOccurrence(i);
                repeatedValues.put(arrayValue, tempValueInformation);
            }
        }
        //
        Integer repeatedMinFirstOccurrence = null, repeatedMaxFirstOccurrence = null, repeatedMinLastOccurrence = null, repeatedMaxLastOccurrence = null;
        Integer uniqueValuesMinIndex = null, repeatedValuesMinLastIndex = null, uniqueValuesMaxIndex = null, repeatedValuesMaxFirstIndex = null;
        for (ValueInformation info : uniqueValues.values()) {
            if (uniqueValuesMinIndex == null) {
                uniqueValuesMinIndex = info.getFirstOccurrence();
            } else {
                uniqueValuesMinIndex = Math.min(info.getFirstOccurrence(), uniqueValuesMinIndex);
            }
            if (uniqueValuesMaxIndex == null) {
                uniqueValuesMaxIndex = info.getFirstOccurrence();
            } else {
                uniqueValuesMaxIndex = Math.max(info.getFirstOccurrence(), uniqueValuesMaxIndex);
            }
        }
        for (ValueInformation info : repeatedValues.values()) {
            // if (repeatedValuesMinLastIndex == null) {
            // repeatedValuesMinLastIndex = info.getLastOccurrence();
            // } else {
            // repeatedValuesMinLastIndex = Math.min(info.getLastOccurrence(), repeatedValuesMinLastIndex);
            // }
            // if (repeatedValuesMaxFirstIndex == null) {
            // repeatedValuesMaxFirstIndex = info.getFirstOccurrence();
            // } else {
            // repeatedValuesMaxFirstIndex = Math.max(info.getFirstOccurrence(), repeatedValuesMaxFirstIndex);
            // }
            repeatedMinFirstOccurrence = safeMin(info.getFirstOccurrence(), repeatedMinFirstOccurrence);
            repeatedMaxFirstOccurrence = safeMax(info.getFirstOccurrence(), repeatedMaxFirstOccurrence);
            repeatedMinLastOccurrence = safeMin(info.getLastOccurrence(), repeatedMinLastOccurrence);
            repeatedMaxLastOccurrence = safeMax(info.getLastOccurrence(), repeatedMaxLastOccurrence);
        }
        repeatedValuesMinLastIndex = repeatedMinLastOccurrence;
        repeatedValuesMaxFirstIndex = repeatedMaxFirstOccurrence;
        int start, end;
        if (repeatedValuesMinLastIndex == null) {
            start = uniqueValuesMinIndex;
        } else if (uniqueValuesMinIndex == null) {
            start = repeatedValuesMinLastIndex;
        } else {
            start = Math.min(uniqueValuesMinIndex, repeatedValuesMinLastIndex);
        }
        if (uniqueValuesMaxIndex == null) {
            end = repeatedValuesMaxFirstIndex;
        } else if (repeatedValuesMaxFirstIndex == null) {
            end = uniqueValuesMaxIndex;
        } else {
            end = Math.max(uniqueValuesMaxIndex, repeatedValuesMaxFirstIndex);
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(array, start, end + 1)));
    }

    private static Integer safeMax(Integer testedMax, Integer currentMax) {
        if (currentMax == null) {
            return testedMax;
        }
        return Math.max(testedMax, currentMax);
    }

    private static Integer safeMin(Integer testedMin, Integer currentMin) {
        if (currentMin == null) {
            return testedMin;
        }
        return Math.max(testedMin, currentMin);
    }
}
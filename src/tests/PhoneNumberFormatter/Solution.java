package tests.PhoneNumberFormatter;

public class Solution {
    public static void main(String[] args) {
        String[] phones = { "11", "111", "1111", "11111", "111111", "1111111", "11111111", "111111111", "1111111111", "11111111111", "111111111111", "1111111111111", "11111111111111",
                "111111111111111", "1111111111111111" };
        for (int i = 0; i < phones.length; i++) {
            process(phones[i]);
        }
    }

    public static void process(String raw) {
        char[] input = raw.replaceAll("[^0-9]+", "").toCharArray();
        int groupSize = 3, groupSizeCounter = 0;
        int extraOutputSize = (input.length / 3) + input.length;
        if (input.length % 3 == 0) {
            extraOutputSize--;
        }
        char[] output = new char[extraOutputSize];
        int outputPointer = 0;
        for (int i = 0; i < input.length; i++) {
            output[outputPointer++] = input[i];
            groupSizeCounter++;
            if (groupSizeCounter == groupSize && i + 1 != input.length) {
                output[outputPointer++] = '-';
                groupSizeCounter = 0;
            } else if (input.length - i == 3) {
                if (groupSizeCounter == 2) {
                    output[outputPointer++] = '-';
                }
                groupSize = 2;
                groupSizeCounter = 0;
            }
        }
        System.out.println(new String(output));
    }
}
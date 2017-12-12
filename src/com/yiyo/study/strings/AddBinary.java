package com.yiyo.study.strings;

public class AddBinary {

    /*
    Given two binary strings, return their sum (also a binary string).
    Example:
    a = "100"
    b = "11"
    Return a + b = “111”.
     */
    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("100", "11"));
    }

    public String addBinary(String A, String B) {
        int i = A.length() - 1;
        int j = B.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder("");

        // We add binary digits from right to left
        while (i >= 0 || j >= 0) {
            // We store the sum of the current digits in the loop
            // We need to take into account the carry for every sum
            int sum = carry;
            if (i >= 0) {
                // char - '0' is needed to avoid summing the key ascii
                sum += A.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += B.charAt(j) - '0';
                j--;
            }
            // Convert sum to one or zero and append it to the result
            result.append(sum % 2);
            // Compute new carry
            carry = sum / 2;
        }

        // If there is any pending carry just append it to the result
        if (carry != 0) {
            result.append(carry);
        }
        // The result has to be reversed
        return result.reverse().toString();
    }
}

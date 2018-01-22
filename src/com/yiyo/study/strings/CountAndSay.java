package com.yiyo.study.strings;

public class CountAndSay {

    /*
    The count-and-say sequence is the sequence of integers beginning as follows:
    1, 11, 21, 1211, 111221, ...

    1 is read off as one 1 or 11.
    11 is read off as two 1s or 21.
    21 is read off as one 2, then one 1 or 1211.

    Given an integer n, generate the nth sequence (as string).
     */
    public static void main(String[] args) {
        CountAndSay count = new CountAndSay();
        System.out.println(count.countAndSay(1));
        System.out.println(count.countAndSay(2));
        System.out.println(count.countAndSay(3));
        System.out.println(count.countAndSay(4));
        System.out.println(count.countAndSay(5));
        System.out.println(count.countAndSay(6));
    }

    private String countAndSay(int A) {
        if (A < 1) {
            return "";
        }

        StringBuilder res = new StringBuilder("1");
        StringBuilder last = new StringBuilder("1");
        int count;
        char num;

        for (int i = 1; i < A; i++) {
            int index = 0;
            int n = last.length();
            res = new StringBuilder();

            while (index < n) {
                num = last.charAt(index);
                count = 1;
                index++;

                while (index < n && last.charAt(index) == num) {
                    index++;
                    count++;
                }

                res.append(String.valueOf(count));
                res.append(String.valueOf(num));
            }
            last = res;
        }
        return res.toString();
    }
}

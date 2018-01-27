package com.yiyo.study.linked_lists;

public class AddTwoNumbersAsList {

    /*
    You are given two linked lists representing two non-negative numbers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.

    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    342 + 465 = 807

    Make sure there are no trailing zeros in the output list
    So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
     */
    public static void main(String[] args) {
        AddTwoNumbersAsList linked = new AddTwoNumbersAsList();

        ListNode A = new ListNode(2);
        ListNode A1 = new ListNode(4);
        ListNode A2 = new ListNode(3);
        A.next = A1;
        A1.next = A2;

        ListNode B = new ListNode(5);
        ListNode B1 = new ListNode(6);
        ListNode B2 = new ListNode(4);
        B.next = B1;
        B1.next = B2;

        ListNode result = linked.addTwoNumbers(A, B);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    private ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        ListNode first = A;
        ListNode second = B;
        ListNode res = null;
        ListNode temp = null;

        while (first != null || second != null) {
            int result = carry;

            if (first != null) {
                result += first.val;
                first = first.next;
            }

            if (second != null) {
                result += second.val;
                second = second.next;
            }

            carry = result / 10;
            if (result >= 10) {
                result = result % 10;
            }

            if (res == null) {
                res = new ListNode(result);
                temp = res;
            } else {
                temp.next = new ListNode(result);
                temp = temp.next;
            }
        }

        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return res;
    }
}

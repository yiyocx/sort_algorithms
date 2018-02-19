package com.yiyo.study.linked_lists;

public class ReverseLinkedList {

    /*
    Reverse a linked list. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL,
    return 5->4->3->2->1->NULL.
     */
    public static void main(String[] args) {
        ReverseLinkedList linkedList = new ReverseLinkedList();

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ListNode reversedList = linkedList.reverseList(A);
        while (reversedList != null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }
    }

    public ListNode reverseList(ListNode A) {
        ListNode prev = null;
        ListNode next;
        ListNode current = A;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        A = prev;
        return A;
    }
}

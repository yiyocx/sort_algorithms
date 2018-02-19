package com.yiyo.study.linked_lists;

/**
 * Time Complexity: O(n)
 */
public class ReverseLinkedListII {

    /*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,
    return 1->4->3->2->5->NULL.

    Note:
    Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list
     */
    public static void main(String[] args) {
        ReverseLinkedListII reverse = new ReverseLinkedListII();

        ListNode A = new ListNode(1);
        A.next = new ListNode(2);
        A.next.next = new ListNode(3);
        A.next.next.next = new ListNode(4);
        A.next.next.next.next = new ListNode(5);

        ListNode reversedList = reverse.reverseBetween(A, 2, 4);
        while (reversedList != null) {
            System.out.print(reversedList.val + " -> ");
            reversedList = reversedList.next;
        }
        System.out.println("null");
    }

    // Efficient way
    private ListNode reverseBetween(ListNode A, int m, int n) {
        if (m == n) {
            return A;
        }

        ListNode pre = null;
        ListNode start = null;
        ListNode end = null;
        ListNode post = null;

        int i = 1;
        ListNode current = A;

        while (current != null && i <= n) {
            if (i < m) {
                pre = current;
            }
            if (i == m) {
                start = current;
            }
            if (i == n) {
                end = current;
                post = current.next;
            }

            current = current.next;
            i++;
        }

        end.next = null;
        end = new ReverseLinkedList().reverseList(start);

        if (pre != null) {
            pre.next = end;
        } else {
            A = end;
        }
        start.next = post;

        return A;
    }

    // This is not efficient with larger inputs for some reason
    private ListNode reverseBetween2(ListNode A, int m, int n) {
        ListNode B = new ListNode(0);
        B.next = A;

        ListNode current = B;
        ListNode preHead = null;
        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i <= n; i++) {
            ListNode next = current.next;

            if (i == m - 1) {
                preHead = current;
            }

            if (i == m) {
                tail = current;
            }

            if (i >= m) {
                current.next = head;
                head = current;
            }

            current = next;
        }

        preHead.next = head;
        tail.next = current;
        return B.next;
    }
}

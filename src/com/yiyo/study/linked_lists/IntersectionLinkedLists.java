package com.yiyo.study.linked_lists;

public class IntersectionLinkedLists {

    /*
    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:
    A:          a1 → a2
                       ↘
                         c1 → c2 → c3
                       ↗
    B:     b1 → b2 → b3
     */
    public static void main(String[] args) {
        IntersectionLinkedLists intersection = new IntersectionLinkedLists();

        // creating first linked list
        ListNode A = new ListNode(3);
        A.next = new ListNode(6);
        A.next.next = new ListNode(15);
        A.next.next.next = new ListNode(15);
        A.next.next.next.next = new ListNode(30);

        // creating second linked list
        ListNode B = new ListNode(10);
        B.next = new ListNode(15);
        B.next.next = new ListNode(30);

        ListNode intersectionNode = intersection.getIntersectionNode(A, B);
        while (intersectionNode != null) {
            System.out.println(intersectionNode.val);
            intersectionNode = intersectionNode.next;
        }
    }

    private ListNode getIntersectionNode(ListNode a, ListNode b) {
        int m = size(a);
        int n = size(b);

        while (m > n) {
            a = a.next;
            m--;
        }

        while (m < n) {
            b = b.next;
            n--;
        }

        while (a != null && b != null) {
            if (a.val == b.val) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private int size(ListNode node) {
        ListNode current = node;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

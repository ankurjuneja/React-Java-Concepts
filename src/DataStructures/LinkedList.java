package DataStructures;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class LinkedList {
    // Merge two sorted lists
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                if (l2 != null) {
                    if (l1.next == null) { // reached end of list 1
                        if (l1.val <= l2.val) {
                            l3 = appendNode(l3, l1);
                            l1 = l1.next;
                        } else {
                            l3 = appendNode(l3, l2);
                            l2 = l2.next;
                        }
                    } else {
                        if (l1.val <= l2.val) {
                            l3 = appendNode(l3, l1);
                            l1 = l1.next;
                        }
                    }
                }
                else {
                    l3 = appendNode(l3, l1);
                    l1 = l1.next;
                }
            }
            if (l2 != null ) {
                if (l1 != null) {
                    if (l2.next == null) { // reached end of list 2
                        if (l2.val <= l1.val) {
                            l3 = appendNode(l3, l2);
                            l2 = l2.next;
                        }
                        else {
                            l3 = appendNode(l3, l1);
                            l1 = l1.next;
                        }
                    }
                    else {
                        if (l2.val <= l1.val) {
                            l3 = appendNode(l3, l2);
                            l2 = l2.next;
                        }
                    }
                }
                else {
                    l3 = appendNode(l3, l2);
                    l2 = l2.next;
                }
            }
        }
        return l3;
    }

    static ListNode appendNode(ListNode head, ListNode nodeToInsert) {
        if (head == null) {
            head = new ListNode(nodeToInsert.val);
        }
        else {
            ListNode currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new ListNode(nodeToInsert.val);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(4);

        ListNode node2 = new ListNode(1);
        node2.next = new ListNode(3);
        node2.next.next = new ListNode(4);

        ListNode mergedList = mergeTwoLists(node1, node2);
    }
}

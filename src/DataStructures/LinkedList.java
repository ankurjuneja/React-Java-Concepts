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

    static ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode temp = l3;
        int sum ;
        int carry = 0;
        while (l1 != null || l2 != null) {
            sum = 0;

            if (l1 == null) {
                sum += l2.val + carry;
                l2 = l2.next;
            }
            else if (l2 == null) {
                sum += l1.val + carry;
                l1 = l1.next;
            }
            else {
                sum += l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            temp.val = sum;

            if (l1 != null || l2 != null) {
                temp.next = new ListNode();
                temp = temp.next;
            }
            else if (carry > 0 ) {
                temp.next = new ListNode(carry);
            }
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        // ListNode mergedList = mergeTwoLists(node1, node2);
        // reverseList(node1);
        // addTwoNumbers(node1, node2);
    }
}

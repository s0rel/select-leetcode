```java
/**
 * 遍历两次的解法
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }

        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode previous = dummy;
        while (head != null) {
            if (count == length - n) {
                previous.next = head.next;
                break;
            }

            previous = head;
            head = head.next;
            count++;
        }
        return dummy.next;
    }
}
```
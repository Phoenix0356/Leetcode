package easy;

import util.ListNode;

public class hasCycle {

        public boolean hasCycle(ListNode head) {
                if (head == null) return false;
                int value = -1100000;
                head.val = -1100001;
                while (head.next != null) {
                    head.next.val = value;
                    head.next = head.next.next;
                    if (head.next!=null) {
                        break;
                    }else {
                        if (head.next.val <= value) return true;
                        value++;
                    }
                }
                return false;

    }
}


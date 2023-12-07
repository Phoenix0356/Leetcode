package medium;

import util.ListNode;
import util.Node;

import java.util.HashMap;
import java.util.HashSet;

public class detectCycle {
    HashSet<ListNode> set=new HashSet<>();
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        if (!set.contains(head)){
            set.add(head);;
            return detectCycle(head.next);
        }else return head;
    }

}

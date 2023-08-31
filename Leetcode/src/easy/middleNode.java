package easy;

import util.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class middleNode {
    public ListNode middleNode(ListNode head) {
        //暴力法
//        ArrayList<ListNode> list=new ArrayList<>();
//        while (head!=null){
//            list.add(head);
//            head=head.next;
//        }
//        return list.get(list.size()/2+1);
        //快慢指针
        ListNode slow=head,fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

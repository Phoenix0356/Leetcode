package easy;

import util.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class reverseList {
    public ListNode reverseList(ListNode head) {
        ArrayList<ListNode> l=new ArrayList<>();
        while (head!=null){
            l.add(head);
            head=head.next;
        }
        int len=l.size()-1;
        while (len>0){
            l.get(len).next=l.get(len-1);
            len--;
        }
        return l.get(l.size()-1);
    }
}

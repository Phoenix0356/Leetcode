import util.ListNode;

public class mergeNodes {
    public ListNode mergeNodes(ListNode head) {
        ListNode temp=head;
        ListNode after;
        while (temp.next!=null){
            if (temp.next.val!=0){
                temp.val+=temp.next.val;
                temp.next=temp.next.next;
                after=temp;
            }else {
                temp.next=temp.next.next;
                after=temp.next;
            }
        }
        return temp;
    }
}

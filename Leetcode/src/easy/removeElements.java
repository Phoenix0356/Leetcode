package easy;

import util.ListNode;

public class removeElements {



    public ListNode removeElements(ListNode head, int val) {
            //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
            while(head!=null&&head.val==val){
                head=head.next;
            }
            if(head==null)
                return head;
            ListNode prev=head;
            //确保当前结点后还有结点
            while(prev.next!=null){
                if(prev.next.val==val){
                    prev.next=prev.next.next;
                }else{
                    prev=prev.next;
                }
            }
            return head;
        }
}

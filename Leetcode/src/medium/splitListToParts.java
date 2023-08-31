package medium;

import util.ListNode;

import java.util.ArrayList;

public class splitListToParts {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ArrayList<ListNode> list=new ArrayList<>();
        ListNode[] arr=new ListNode[k];
        if (head==null) return arr;
        while (head!=null){
            list.add(head);
            head=head.next;
        }
        int len=list.size(),prev=0,ind=0;
        arr[0]=list.get(0);
        while (++ind<arr.length){

            int l=len/k;

            if (len%k!=0) l++;
            len-=l;

            prev+=l;
            if (prev==list.size())break;
            list.get(prev-1).next=null;
            arr[ind]=list.get(prev);

        }
        return arr;
    }
}

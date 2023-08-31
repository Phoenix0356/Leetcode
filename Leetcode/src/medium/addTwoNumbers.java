package medium;

import util.ListNode;

import java.util.ArrayList;

public class addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ArrayList<ListNode> list1=new ArrayList<>();
        ArrayList<ListNode> list2=new ArrayList<>();
        while (l1!=null){
            list1.add(l1);
            l1=l1.next;
        }
        while (l2!=null){
            list2.add(l2);
            l2=l2.next;
        }
        int sum=list1.get(list1.size()-1).val+list2.get(list2.size()-1).val,carry=0;
        if (sum>10){
            sum-=10;
            carry=1;
        }
        ListNode last=new ListNode(sum,null);
        int len=Math.min(list1.size(),list2.size());
        for (int i=2;i<=len;i++){
            last= new ListNode(sum+carry,last);
            sum=list1.get(list1.size()-i).val+list2.get(list2.size()-i).val;
            carry=0;
            if (sum>10){
                sum-=10;
                carry=1;
            }
        }
        return last;
    }
}

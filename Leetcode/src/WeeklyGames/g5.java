package WeeklyGames;

import util.ListNode;

import java.util.*;

public class g5 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int ans=(100-purchaseAmount)%10>=5?(100-purchaseAmount)/10+1:(100-purchaseAmount)/10;
        return ans*10;

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode insert=new ListNode(),cur=head;
        while (cur!=null){
            if (cur.next==null) break;
            insert=new ListNode();
            insert.val=findGcd(cur.val,cur.next.val);
            ListNode temp;
            temp=cur.next;
            insert.next=temp;
            cur.next=insert;
            cur=insert.next;
        }
        return head;
    }

    int findGcd(int num1,int num2){
        int ans=0;
        for (int i=Math.min(num1,num2);i>0;i--){
            if (num1%i==0&&num2%i==0){
                ans=i;
                break;
            }
        }
        return ans;
    }
    public int minimumSeconds(List<Integer> nums) {
        Collections.sort(nums);
        int[] map=new int[nums.size()];
        int[] distance=new int[nums.get(nums.size()-1)];
        Arrays.fill(distance,-1);

        for (int i=0;i<nums.size();i++){
            int num=nums.get(i);
            int preDis;
            if (distance[num]==-1) {
                preDis=-1;
            }else {
                preDis=distance[num];
            }
            distance[num]=i;

            if (preDis!=-1) {
                int dis=i-preDis;
                if (dis>nums.size()/2) dis=nums.size()-dis;
                map[num]=Math.max(dis,map[num]);
            }else {
                map[num]=i;;
            }
        }
        Arrays.sort(map);
        return map[map.length-1]%2>0?map[map.length-1]/2+1:map[map.length-1]/2;

    }
}

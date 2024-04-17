package WeeklyGames;

import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class g9 {
    public boolean canBeEqual(String s1, String s2) {
        for (int i=0;i<4;i++){
            if (s1.charAt(i)!=s2.charAt(i)){
                if (i<2){
                    if (s1.charAt(i)!=s2.charAt(i+2)||s1.charAt(i+2)!=s2.charAt(i)) return false;
                }else {
                    if(s1.charAt(i)!=s2.charAt(i-2)||s1.charAt(i-2)!=s2.charAt(i)) return false;
                }
            }

        }
        return true;
    }
    public boolean checkStrings(String s1, String s2) {
        int len=s1.length();
        int[] evenS1=new int[len/2],oddS1=new int[len%2==0?len/2:len/2+1];
        int[] evenS2=new int[len/2],oddS2=new int[len%2==0?len/2:len/2+1];
        for (int i=0;i<s1.length();i++){
            if (i%2==0){
                evenS1[i/2]=s1.charAt(i);
                evenS2[i/2]=s2.charAt(i);
            }else {
                oddS1[i/2+1]=s1.charAt(i);
                oddS2[i/2+1]=s2.charAt(i);
            }
        }
        Arrays.sort(evenS1);
        Arrays.sort(evenS2);
        Arrays.sort(oddS1);
        Arrays.sort(oddS2);

        return Arrays.equals(evenS1,evenS2)&&Arrays.equals(oddS1,oddS2);
    }
    public long maxSum(List<Integer> nums, int m, int k) {
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        long sum=0,max=0;
        int left=0;
        for (int i=0;i<k;i++){
            sum+=nums.get(i);
            set.add(nums.get(i));
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1 );
        }
        if (set.size()>=m) max=Math.max(sum,max);
        for (int right=k;right<nums.size();right++){
            int removed=nums.get(left++),added=nums.get(right);
            sum-=removed;sum+=added;

            map.put(removed, map.get(removed)-1);
            map.put(added,map.getOrDefault(added,0)+1);

            if (map.get(removed)==0) set.remove(removed);
            set.add(added);
            if (set.size()>=m) max=Math.max(sum,max);

        }
        return max;

    }
//    public int countKSubsequencesWithMaxBeauty(String s, int k) {
//        int[] arr=new int[26];
//        for (int i=0;i<s.length();i++) arr[s.charAt(i)-'a']++;
//        Arrays.Sort(arr);
//        int ind=26;
//        int temp=k;
//        while (temp>0) temp-=arr[--ind];
//        int limit=arr[--ind];
//        int total=arr[--ind];
//        for (int i=ind-1;i>=0;i--){
//            if (arr[i]==limit) total+=limit;
//        }
//        int up=1,down=1;
//        for (int i=total;i>=arr[ind]+k;i--){
//            up*=i;
//        }
//        for (int i=arr[ind]+k;i>=1;i--){
//            down*=i;
//            }
//        return up/down;
//    }
}

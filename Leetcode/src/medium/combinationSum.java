package medium;

import java.util.*;

public class combinationSum {
    List<List<Integer>> ans;
    HashSet<Integer> set;
    Thread thread;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->o1-o2);
        ans = new ArrayList<>();
        set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        backTrack(candidates,list,0,target);
        return ans;
    }

    void backTrack(int[] candidates,List<Integer> list,int curSum, int target){
        if(curSum == target){
            var newList = getList(list);
            if(newList!=null) ans.add(newList);
            return;
        }

        if(curSum>target) return;

        for(int num:candidates){
            list.add(num);
            backTrack(candidates,list,curSum+num,target);
            list.remove(list.size()-1);
        }
    }

    List<Integer> getList(List<Integer> list){
        List<Integer> newList = new ArrayList<>();
        int[] arr = new int[41];
        for(int num:list){
            arr[num]++;
            newList.add(num);
        }
        boolean isExist = set.add(Arrays.hashCode(arr));
        return isExist?newList:null;
    }
}

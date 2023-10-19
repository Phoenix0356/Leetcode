package hard;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DinnerPlates {
    ArrayList<int[]> plates;
    ArrayList<Integer> height;
    PriorityQueue<Integer> spaces;
    int plateSize;
    int curHeight;
    public DinnerPlates(int capacity) {
        plates=new ArrayList<>();
        height=new ArrayList<>();
        spaces=new PriorityQueue<>((o1, o2) -> o1-o2);
        plateSize=capacity;
        curHeight=0;
        height.add(0);
        plates.add(new int[capacity]);

    }
    public void pushNew(int val){
        int[] nums=new int[plateSize];
        nums[0]=val;
        plates.add(nums);
        height.add(0);
        curHeight++;
    }

    public void push(int val) {
        int curH=height.get(curHeight);
        if (!spaces.isEmpty()){
            int curInd=spaces.poll();
            curH=height.get(curInd);
            int[] nums=plates.get(curInd);
            nums[++curH]=val;
            height.set(curInd,curH);
            plates.set(curInd,nums);
        }else {
            if (++curH == plateSize) {
                pushNew(val);
            } else {
                int[] nums = plates.get(curH);
                nums[curH-1] = val;
                height.set(curHeight, curH);
                plates.set(curHeight, nums);
            }
        }
        for (int h : height) {
            System.out.println(h);
        }
        System.out.println();
    }

    public int pop() {
        int lastInd=height.size()-1;
        if (lastInd==0) return -1;
        while (height.get(lastInd)==0){
            lastInd--;
            if (lastInd==-1) return -1;
        }
        int lastHeight=height.get(lastInd);
        height.set(lastInd,lastHeight-1);
        if (lastHeight-1==0) curHeight--;
        return plates.get(lastInd)[lastHeight];
    }

    public int popAtStack(int index) {
        if (height.get(index)==null) return -1;
        spaces.add(index);
        height.set(index, height.get(index)-1);
        return plates.get(index)[height.get(index)+1];
    }
}

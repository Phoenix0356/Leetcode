package medium;

import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] arr = new int[20000];

    int length = 0;

    Random random = new Random();
    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        arr[length] = val;
        map.put(val,length);
        length++;
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int targetRef = map.get(val);
        map.put(arr[length-1],targetRef);
        map.remove(val);

        int temp = arr[length-1];
        arr[length-1] = val;
        arr[targetRef] = temp;

        length--;
        return true;
    }

    public int getRandom() {
        int randNum = random.nextInt(length);
        return arr[randNum];
    }
}

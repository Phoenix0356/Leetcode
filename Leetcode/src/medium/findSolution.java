package medium;

import java.util.ArrayList;
import java.util.List;

public class findSolution {
    public class CustomFunction{
        public int f(int x,int y){return 0;}
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int x = 1, y = 1000; x <= 1000 && y >= 1; x++) {
            while (y >= 1 && customfunction.f(x, y) > z) {
                y--;
            }
            if (y >= 1 && customfunction.f(x, y) == z) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(x);
                pair.add(y);
                res.add(pair);
            }
        }
        return res;
    }
}

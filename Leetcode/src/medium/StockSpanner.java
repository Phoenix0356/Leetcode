package medium;

import java.util.ArrayList;

public class StockSpanner {
    ArrayList<Integer> node ;
    ArrayList<Integer> count;
    int cnt=1;
    boolean isFirst=true;
    int pre;
    public StockSpanner() {
        node=new ArrayList<>();
        count=new ArrayList<>();
    }

    public int next(int price) {
        int ans=1;
        if (isFirst) {
            pre=price;
            isFirst=false;
            return 1;
        }
        if (price >= pre) {
            cnt++;
            ans=cnt;
        } else {
            node.add(pre);
            count.add(cnt);
            cnt = 1;
            return ans;
        }
        for (int i = node.size() - 1; i >= 0; i--) {
            if (price >= node.get(i)) {
                ans += count.get(i);
            } else break;
        }
        pre=price;
        return ans;
    }

}

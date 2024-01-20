package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class filterRestaurants {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants,(o1,o2)->{
            if (o1[1]==o2[1]) return o2[0]-o1[0];
            return o2[1]-o1[1];
        });
        List<Integer> list=new ArrayList<>();
        for (int[] res:restaurants){
            int id=res[0],rating=res[1],vf=res[2],price=res[3],dis=res[4];
            if (veganFriendly==0||(veganFriendly==1&&vf==1)){
                if (price <= maxPrice && dis <= maxDistance) list.add(id);
            }
        }

        return list;
    }
}

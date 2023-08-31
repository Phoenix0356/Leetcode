package easy;

import java.util.*;

public class findRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> s=new ArrayList<>();
        int count=3000;
        for (int i=0;i< list1.length;i++){
            for (int j=0;j< list2.length;j++){
                if (list1[i].equals(list2[j])){
                    if (count<i+j){
                    } else if (count==i+j){
                        s.add(list1[i]);

                    }else if(count>i+j) {
                        s.removeAll(s);
                        s.add(list1[i]);
                        count=i+j;
                    }
                    break;
                }
            }
        }
        return s.toArray(new String[s.size()]);
    }
}

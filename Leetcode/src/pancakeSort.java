import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pancakeSort {
    public List<Integer> pancakeSort(int[] arr) {List<Integer> res=new ArrayList<>();
        int max=arr.length,end=arr.length-1;
        for (int z=0;z<arr.length-1;z++) {
            int i = 0;
            if (arr[end] == max) {
                z++;
                end--;
                max--;
            } else {
                inner:for (; i < arr.length; i++) {
                    if (arr[i] == max) {
                        res.add(i + 1);
                        res.add(max);
                        reverse(i, arr);
                        reverse(end, arr);
                        max--;
                        end--;
                        break inner;
                    }
                }
            }
        }
        return res;
    }
    void reverse(int ind,int[] arr){
        int temp=0;
        if (ind==0)return;
        for (int j=0;j<=(ind-1)/2;j++){
            temp=arr[ind];
            arr[ind]=arr[j];
            arr[j]=temp;
            ind--;
        }
    }

}

package medium;

import java.util.ArrayList;
import java.util.List;

public class simplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        ArrayList<Integer> denominator=new ArrayList<>();
        ArrayList<String> res= new ArrayList<String>();
        for(int i=0;i<n-1;i++){
            denominator.add(i+2);
            int numerator=1;
            inner:while(numerator<denominator.get(i)){
                if (numerator!=1){
                    if (isPrinum(numerator,denominator.get(i))) {
                        numerator++;
                    }else{
                        res.add(String.valueOf(numerator) + "/" + String.valueOf(denominator.get(i)));
                        numerator++;
                    }
                }else {
                    res.add(String.valueOf(numerator) + "/" + String.valueOf(denominator.get(i)));
                    numerator++;
                }
            }
        }
        return res;
    }
    public boolean isPrinum(int n,int i){
        if(i%n==0)return true;
        if(i%(i%n)==0&&i%n!=1)return true;
        return false;
    }

}

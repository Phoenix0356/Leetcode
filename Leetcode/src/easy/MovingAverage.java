package easy;

import java.util.ArrayList;

public class MovingAverage {
    int size;
    ArrayList<Double> list;
    public MovingAverage(int size) {
        this.size=size;
        this.list=new ArrayList<>();
    }

    public double next(int val) {
        double sum=0;
        list.add((double)val);
        if (list.size()>size){
            for (int i=list.size()-1;i>=list.size()-size;i--){
                sum+=list.get(i);
            }
            return sum/size;
        }else {
            for (int i=0;i<list.size();i++){
                sum+=list.get(i);
            }
            return sum/ list.size();
        }
    }
}

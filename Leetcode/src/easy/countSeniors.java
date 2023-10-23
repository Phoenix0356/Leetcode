package easy;

public class countSeniors {
    public int countSeniors(String[] details) {
        int count=0;
        for (int i=0;i<details.length;i++){
            String s=details[i].substring(10,12);
            if (Integer.parseInt(s)>60) count++;
        }
        return count;
    }
}

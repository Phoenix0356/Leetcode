package medium;

public class winnerOfGame {
    public boolean winnerOfGame(String colors) {
        String[] coler=colors.split("");
        int numOfA=0,numOfB=0,roundOfA=0,roundOfB=0;
        for (String s:coler){
            if (s.equals("A")){
                numOfA++;
                numOfB=0;
            }else {
                numOfB++;
                numOfA=0;
            }
            if (numOfA==3){numOfA--;roundOfA++;}
            if (numOfB==3){numOfB--;roundOfB++;}
        }
        return roundOfA>roundOfB;
    }
}

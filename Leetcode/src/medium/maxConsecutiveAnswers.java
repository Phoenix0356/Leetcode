package medium;

public class maxConsecutiveAnswers {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] ch=answerKey.toCharArray();
        int[] numOfContinue=new int[answerKey.length()];
        int ind=0,count=0,num=k,tempCount=0;
        boolean isT=true;
        for (char c:ch){
            if (Character.compare(c,'T')==0&&isT==true){
                numOfContinue[ind]++;
            }else if (Character.compare(c,'F')==0&&isT==true){
                isT=false;
                numOfContinue[ind++]++;
            }else if (Character.compare(c,'F')==0&&isT==false){
                numOfContinue[ind]++;
            }else {
                isT=true;
                numOfContinue[ind++]++;
            }
        }
        for (int i=1;numOfContinue[i]!=0||i<numOfContinue.length;i++){
                if (numOfContinue[i]<num&&numOfContinue[i]!=0){
                    tempCount+=numOfContinue[i-1]+numOfContinue[i]+numOfContinue[i+1];
                    num-=numOfContinue[i];
                    i++;
                }
                if (num<numOfContinue[i+1]){
                    num=k;
                    count=Math.max(tempCount,count);
                    tempCount=numOfContinue[i+1];
                }
            }

        return count;
    }
}

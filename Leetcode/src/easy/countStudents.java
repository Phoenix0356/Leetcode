package easy;

public class countStudents {
    public int countStudents(int[] students, int[] sandwiches) {
//        int ind=0,l=students.length,cnt=l;
//        int preCnt=l;
//        boolean isFinished=false;
//        boolean[] flag=new boolean[2*l];
//        while (!isFinished){
//            for (int i=0;i<l;i++){
//                if (flag[i]||flag[ind+l]) continue;
//                if (students[i]==sandwiches[ind]) {
//                    flag[i]=true;
//                    flag[ind+l]=true;
//                    ind++;
//                    cnt--;
//                }
//            }
//            if (preCnt==cnt) isFinished=true;
//            preCnt=cnt;
//        }
//        return cnt;
        int numOfStu=0,numOfBre=0;
        for (int i=0;i<students.length;i++){
            if (students[i]==1) numOfStu++;
            if (sandwiches[i]==1) numOfBre++;
        }
        return Math.abs(numOfBre-numOfStu);
    }
}

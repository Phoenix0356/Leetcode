package medium;

public class TopVotedCandidate {
    int[] persons;
    int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons=persons;
        this.times=times;
    }

    public int q(int t) {
        int[] indOfPerson=new int[persons.length];;
        int ind=-1,cur=0,max=0;
        while (++ind<times.length&&times[ind]<=t){
            indOfPerson[persons[ind]]++;
            cur=persons[ind];
        }
        for (int ofPerson : indOfPerson) {
            if (max < ofPerson) {
                max = ofPerson;
            }
        }
        if (indOfPerson[cur]<max) {
            for (int i = persons.length - 1; i >= 0; i--) {
                if (indOfPerson[persons[i]]==max){
                    cur=persons[i];
                    break;
                }
            }
        }

        return cur;
    }
}

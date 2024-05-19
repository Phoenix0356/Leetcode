package WeeklyGames;

import java.util.Arrays;
import java.util.HashMap;

public class g22 {
    public boolean isValid(String word) {
        word = word.toLowerCase();
        char[] arr = word.toCharArray();
        if (arr.length<3) return false;
        boolean flagY = false;
        boolean flagF = false;
        boolean flagIllegal = true;
        for (int cur : arr) {
            if (cur <= 'z' && cur >= 'a') {
                if (cur == 'a' || cur == 'e' || cur == 'i' || cur == 'o' || cur == 'u') {
                    flagY = true;
                    continue;
                }
                flagF = true;
            }
            if (cur == '@' || cur == '#' || cur == '$') {
                flagIllegal = false;
            }

        }
        return flagY&&flagF&&flagIllegal;
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        char[] arr = word.toCharArray();
        int max = 0,cnt = arr.length/k;
        HashMap<Integer,Integer> map = new HashMap<>();
        int wi = 0;
        for (int i = 0;i<word.length();i=wi*k){
            int curHash = getHash(arr,i,k);
            map.put(curHash,map.getOrDefault(curHash,0)+1);
            max = Math.max(max,map.get(curHash));
            wi++;
        }
        return cnt - max;
    }

    int getHash(char[] arr,int start,int len){
        int hash = 0;
        for (int i = start;i<start+len;i++){
            hash= 31*hash+arr[i];
        }
        return hash;
    }


    public int minAnagramLength(String s) {
        int len = s.length();

        char[] chars = s.toCharArray();
        for (int i = 1;i< chars.length;i++){
            if (len%i == 0){
                int[] matchArr = fillMatchArr(chars, i);
                if (judge(chars,matchArr,i)){
                    return i;
                }

            }
        }
        return len;
    }

    int[] fillMatchArr(char[] chars, int len){
        int[] arr = new int[26];
        for (int i = 0; i< len; i++){
            arr[chars[i]-'a']++ ;
        }
        return arr;
    }

    boolean judge(char[] chars,int[] matchArr,int len){
        int start = 0;
        int[] temp = new int[26];
        while (start<chars.length){
            temp[chars[start++]-'a']++;
            if (start%len == 0){
                if (!isValid(matchArr,temp)) {
                    return false;
                }
                temp = new int[26];
            }
        }
        return true;
    }

    boolean isValid(int[] matchArr,int[] temp){
        for (int i = 0;i<26;i++){
            if(matchArr[i]!=temp[i]) return false;
        }
        return true;
    }
}

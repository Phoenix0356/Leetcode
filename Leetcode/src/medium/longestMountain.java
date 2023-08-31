package medium;

public class longestMountain {
    public int longestMountain(int[] arr) {
        int count=0,max=0;
        boolean isUp=false,isDown=false;
        for (int i=1;i< arr.length;i++){
            if (arr[i-1]<arr[i]) {
                System.out.println("!!!!!!!!!!!!");
                if (!isUp) {
                    isUp = true;
                    isDown=false;
                    max = Math.max(max, count);
                    count = 2;
                }else count++;
            }
            else if (arr[i-1]>arr[i]) {
                if (isUp) {
                    count++;
                    isUp = false;
                    isDown=true;
                }else if (isDown){
                    count++;
                }
            }
        }

        return Math.max(max, count);
    }
}

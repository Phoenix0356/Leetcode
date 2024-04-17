package algorithm;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Random;

public class Sort {
    static int arrLen = 5000;
    static int traverseTimes = 1000;

    public static void main(String[] args) {
        RandomArray randomArray = new RandomArray(arrLen);
        int[] nums = randomArray.getRandomArr();
        sortTest("归并",nums,() -> mergeSort(nums));
        sortTest("冒泡",nums,()->bubbleSort(nums));
        sortTest("插入",nums,()->insertionSort(nums));
    }
    static void sortTest(String sortName,int[] nums,Strategy strategy){

        long start = System.currentTimeMillis();

        for (int i =0;i<traverseTimes;i++) {
            strategy.sortStrategy();
        }

        System.out.print(sortName+"  ");
        System.out.print("耗时："+(System.currentTimeMillis()-start)+"ms"+"  ");
        System.out.println("是否有效："+isSortValid(nums));

    }

    public static boolean isSortValid(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]>nums[i]) return false;
        }
        return true;
    }
    private static void swap(int[] nums,int leftInd,int rightInd){
        int temp = nums[leftInd];
        nums[leftInd] = nums[rightInd];
        nums[rightInd] = temp;
    }

    public static void printArr(int[] nums){
        for (int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
    }

    //冒泡排序
    public static void bubbleSort(int[] nums){
        for (int i = 0;i < nums.length;i++){
            for (int j = 1;j< nums.length-i;j++){
                if (nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
                }
            }
        }
    }

    //插入排序
    public static void insertionSort(int[] nums){
        for (int i = 0;i< nums.length;i++){
            for (int j = i+1;j< nums.length;j++){
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }


    //归并排序
    public static void mergeSort(int[] nums){
        doMergeSort(nums,0, nums.length-1);
    }
    private static void doMergeSort(int[] nums, int left, int right){
        if (left<right){
            //提前判断，无需分解到最小节点
            if (right - left == 1){
                if (nums[left]>nums[right]) {
                    swap(nums, left, right);
                }
                return;
            }

            int mid = left+(right-left)/2;
            doMergeSort(nums,left,mid);
            doMergeSort(nums,mid+1,right);
            merge(nums,left,mid,right);
        }
    }
    private static void merge(int[] nums,int left,int mid,int right){
        int[] temp = new int[right-left+1];

        int leftPointer = left;
        int rightPointer = mid+1;
        int ind = 0;

        while (leftPointer<=mid&&rightPointer<=right){
            int l = nums[leftPointer];
            int r = nums[rightPointer];
            if (l<=r){
                temp[ind++] = nums[leftPointer++];
            }else {
                temp[ind++] = nums[rightPointer++];
            }
        }

        while (leftPointer<=mid){
            temp[ind++] = nums[leftPointer++];
        }

        while (rightPointer<=right){
            temp[ind++] = nums[rightPointer++];
        }

        for (int i = 0,j = left; i < temp.length; i++,j++) {
            nums[j] = temp[i];
        }
    }



    public static class RandomArray{
        private final int[] arr;
        private final Random rand;
        public RandomArray(int arrSize){
            rand = new Random();
            arr = new int[arrSize];
        }

        public int[] getRandomArr(){
            for (int i = 0; i < arr.length; i++) {
                arr[i] = rand.nextInt(100);
            }
            return arr;
        }
    }
    interface Strategy{
        public void sortStrategy();
    }
}

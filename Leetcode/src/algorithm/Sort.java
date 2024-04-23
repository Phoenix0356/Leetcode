package algorithm;

import java.util.*;

public class Sort {
    static int arrLen = 100000;
    static int iterationCounts = 1;

    @SuppressWarnings("all")
    public static void main(String[] args) throws InterruptedException {
       
        RandomArray randomArray = new RandomArray(arrLen);

        sortTest("JDK", randomArray.getRandomArr(), nums ->{Arrays.sort(nums);});

        sortTest("单线程归并",randomArray.getRandomArr(),nums ->{mergeSort(nums);});
        sortTest("冒泡",randomArray.getRandomArr(),nums -> bubbleSort(nums));
        sortTest("选择",randomArray.getRandomArr(),nums -> selectiveSort(nums));
        sortTest("插入",randomArray.getRandomArr(),nums -> insertSort(nums));
        sortTest("2线程归并",randomArray.getRandomArr(),nums->{
            int[] partLeft = Arrays.copyOfRange(nums, 0, nums.length / 2);
            int[] partRight = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
            Thread thread1 = new Thread(() -> mergeSort(partRight));
            Thread thread2 = new Thread(() -> mergeSort(partLeft));
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            mergeSorted(nums,partLeft,partRight);
        });
    }
    static void sortTest(String sortName,int[] nums,Strategy strategy) throws InterruptedException {
        long start = System.currentTimeMillis();

        strategy.sortStrategy(nums);

        System.out.print(sortName+"  ");
        System.out.print("耗时："+((System.currentTimeMillis()-start))+"ms"+"  ");
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

    public static void mergeSorted(int[] nums,int[] partLeft,int[] partRight){
        int leftPointer = 0;
        int rightPointer = 0;
        int ind = 0;
        while (leftPointer < partLeft.length && rightPointer < partRight.length) {
            int l = partLeft[leftPointer];
            int r = partRight[rightPointer];
            if (l <= r) {
                nums[ind++] = l;
                leftPointer++;
            } else {
                nums[ind++] = r;
                rightPointer++;
            }
        }

        while (leftPointer < partLeft.length) {
            nums[ind++] = partLeft[leftPointer++];
        }

        while (rightPointer < partRight.length) {
            nums[ind++] = partRight[rightPointer++];
        }
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

    //选择排序
    public static void selectiveSort(int[] nums){
        for (int i = 0;i< nums.length;i++){
            int minInd = i;
            for (int j = i+1;j< nums.length;j++){
                if (nums[minInd]>nums[j]){
                    minInd = j;
                }
            }
            swap(nums,i,minInd);
        }
    }

    //插入排序
    public static void insertSort(int[] nums){
        for (int i = 0;i< nums.length-1;i++){
            for (int j = i+1;j>0;j--){
                if (nums[j-1]>nums[j]){
                    swap(nums,j-1,j);
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
        void sortStrategy(int[] nums) throws InterruptedException;
    }
}

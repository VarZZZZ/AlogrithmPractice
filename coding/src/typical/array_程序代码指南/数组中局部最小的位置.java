package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/8 9:32
 * @Version 1.0
 * arr长度为1，arr[0]局小，如果arr[n-1]<arr[n-2] 局小， 如果 arr[i-1]>arr[i]<arr[n-2],arr[i]局小
 */
public class 数组中局部最小的位置 {
    // 利用二分
    // 1.如果arr.len=1，或者arr[0]<arr[1]，返回arr[0]
    // 2. 如果arr[n-1]<arr[n-2] 返回arr[n-1]
    // 3.否则，令left = 1,right = N-2，进入步骤4 二分
    // 4.令mid = (left+right)/2
        //1).如果arr[mid]>arr[mid-1]则arr[left..mid-1]上必有局部最小,令right=mid-1
            // 因为arr[1]<arr[0]，所以是呈现递减形式，但是又有arr[mid-1]<arr[mid]，往上升了，则必然存在一个曲折
        //2).
    private int getLessIdx(int[] arr){
        if(arr==null||arr.length==0){
            return -1;
        }
        if(arr.length==1||arr[0]<arr[1]){
            return 0;
        }
        if(arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while(left<right){
            mid = (left+right)/2;
            if(arr[mid]>arr[mid-1]){
                right = mid-1;
            }else if(arr[mid]>arr[mid+1]){
                left = mid+1;
            }else{
                return mid;
            }
        }
        return left;

    }
}

package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/3 23:22
 * @Version 1.0
 */
public class 需要排序的最短子数组长度 {
    // 先从右往左遍历，记录出现过的最小值min,如果arr[i]>min,则表明min需要放到arr[i]的左边， 最起码arr[i】是需要调整的；
    // 同理，在从左往右遍历；
    private int sol(int[] arr){
        int n = arr.length;
        int min = arr[n-1];
        int max= arr[0];
        int noMinIdx= -1;
        for(int i = n-2;i!=-1;i--){
            if(arr[i]>min){
                noMinIdx=i;
            }else{
                min = Math.min(arr[i],min);
            }
        }
        if(noMinIdx==-1) return 0;
        int noMaxIdx=-1;
        for(int i=1;i<n;i++){
            if(arr[i]<max){
                noMaxIdx=i;
            }else{
                max = Math.max(arr[i],max);
            }
        }
        return noMaxIdx-noMinIdx+1;
    }
}

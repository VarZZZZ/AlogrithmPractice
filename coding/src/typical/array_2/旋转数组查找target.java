package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/7/24 11:03
 * @Version 1.0
 */
public class 旋转数组查找target {
    private boolean search(int[] arr,int k){
        int l=0,r=arr.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(arr[m]==k) return true;
            if(arr[l]==arr[m]&&arr[l]==arr[r]) // 去除掉两端重复的
            {
                l++;
                r--;
                continue;
            }
            // 先判断m所在哪一段;再判断target所在位置
            if(arr[m]>=arr[0]){
                if(k>=arr[l]&&k<arr[m]){ // 先确定肯定的一段，即k在连续递增的一段
                    r = m-1;
                }else{
                    l = m+1;
                }
            }else{
                if(k<=arr[r]&&k>arr[m]){
                    l = m+1;
                }else{
                    r = m-1;
                }
            }
        }
        return true;
    }
}

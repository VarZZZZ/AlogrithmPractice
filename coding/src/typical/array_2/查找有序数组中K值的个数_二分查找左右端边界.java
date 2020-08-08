package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/7/15 9:11
 * @Version 1.0
 */
public class 查找有序数组中K值的个数_二分查找左右端边界 {
    /**
     * 注意与一般的求中位数不同，
     * @param arr
     * @param k
     * @return
     */
    private static int getKNum(int[] arr,int k){
        int l=0,r=arr.length-1;
        int mid=0;
        while(l<=r){           // 注意最后一次循环有两种情况，l在最右端，arr[r]>k；2.r在最右端,arr[r]==k;
            mid = (l+r)/2;
            if(arr[mid]>k){
                r = mid-1;
            }else{                  // 需要求右边界，自然需要让左往右靠
                l = mid+1;             //先找到最右边的边界，当退出循环时，必然会出现r<l,且当前l超过了最右边
            }
        }
        int right = l-1;
        if(arr[right]!=k) return 0;

        r = l;
        l=0;
        while(l<=r){            // 必须是l<=r ,且不能是l=mid; 防止[2,2],[1]这样的情况
            mid = (l+r)/2;
            if(arr[mid]<k){
                l = mid+1;
            }else{     // arr[mid]<=k
                r = mid-1;    // 把右边界向左边靠拢
            }
        }
        if(arr[r+1]!=k) return 0;

        return right-(r+1)+1;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3,3,3,3};
        System.out.println(getKNum(arr,1));
    }
}

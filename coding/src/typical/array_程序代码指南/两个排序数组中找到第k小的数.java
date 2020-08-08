package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/9 10:20
 * @Version 1.0
 */
public class 两个排序数组中找到第k小的数 {

    /**
     * 获取合并后的中位数
     */
    private int getUpMedian(int[] a1,int s1,int e1,int[] a2,int s2,int e2){
        int mid1=0;
        int mid2 = 0;
        int offset = 0; // 如果元素个数为奇数，则为0，否则为1
        while(s1<e1){ // a1.length<=a2.length
            mid1 = (s1+e1)/2;
            mid2  =(s2+e2)/2;
            offset = ((e1-s1+1)&1)^1; // 奇偶数，如果s1 e1 之间的数字个数为偶数，则为1
            if(a1[mid1]>a2[mid2]){   // 如果a1的中位数大于a2的中位数，则上中位数会位于a1的中位数左边，a2的中位数右边
                e1=mid1;       // 尾巴向左靠拢，只需要==mid即可
                s2 = mid2+offset; // 左端向右靠拢，需要==mid+offset，如果s1 e1之间数字个数为偶数，为1
            }else if(a1[mid1]<a2[mid2]){
                e2 = mid2;
                s1 = mid1+offset;
            }else{
                return a1[mid1];
            }
        }
        return Math.min(a1[s1],a2[s2]);
    }
    /**
     * 设长度短的数组为shortArr,it's length is lenS;
     * MoreLen's arr is longArr,it's length is lenL;
     * 找到第k小的数的过程
     * 1.如果k<1或k>lenS+lenL,无效
     * 2.如果k<=lenS,则在shortArr和longArr中分别选前k个数，这两段数组中的中文数就是 整体第k小的数
     * 3.如果k>lenS,
     */
    private int findKth(int[] arr1,int[] arr2,int kth){
        int[] longs = arr1.length>= arr2.length?arr1:arr2;
        int[] shorts = arr1.length<arr2.length?arr1:arr2;
        int l  =longs.length;
        int s = shorts.length;
        if(kth<=s){
            return getUpMedian(shorts,0,kth-1,longs,0,kth-1);
        }
        if(kth>l){
            if(shorts[kth-l-1]>=longs[l-1]){ // shorts[kth-l-1]大于longs中的所有数
                return shorts[kth-l-1];
            }
            if(longs[kth-s-1]>=shorts[s-1]){
                return longs[kth-s-1];
            }
            // shorts中0。。kth-l； longs:0,kth-s都不可能
            return getUpMedian(shorts,kth-l,s-1,longs,kth-s,l-1);
        }
        // s<kth<=l
        if(longs[kth-s-1]>=shorts[s-1]){
            return longs[kth-s-1];
        }
        return getUpMedian(shorts,0,s-1,longs,kth-s,kth-1);
    }
}

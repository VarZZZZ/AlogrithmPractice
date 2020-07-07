package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/5 20:35
 * @Version 1.0
 */
public class 计算数组的小和 {
    // s = 1,3,5,2,4,6;  s[0]左边小于或等于s[0]的数的和为0,;s[1]的<=该数的和为1。。。
    //s[2],..s[5]... => 讲这些加起来，得到s的小和

    // 利用归并排序的方法。
    // 将数组分为 l[] 和r[]；左右两个数组都有序，(左子树的必然在右子树的左边，节点内排序可以)
    // 如果l[i]<r[j]，那么产生小和，假设从r[j]往右一直到r[]结束，元素个数为m，那么产生的小和为l[i]*m;
    //
    // 画个二叉归并图

    // p394
    private int getSmallSum(int[] arr){
        return func(arr,0,arr.length-1);
    }

    private int func(int[] arr, int l, int r) {
        if(l==r) return 0;
        int mid = (l+r)/2;
        return func(arr,l,mid)+func(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    private int merge(int[] arr, int l, int mid, int r) {
        int[] h = new int[r-l+1];
        int hi = 0;
        int i = l;
        int j = mid+1;
        int smallSum = 0;
        while(i<=mid&&j<=r){
            if(arr[i]<=arr[j]){
                smallSum +=arr[i]*(r-j+1);
                h[hi++] = arr[i++];
            }else{
                h[hi++] = arr[j++]; //右节点上
            }
        }
        for(;(j<r+1)||(i<mid+1);j++,i++){
            h[hi++] = i>mid?arr[j]:arr[i];
        }
        for(int k=0;k!=h.length;k++){  //覆盖回原数组
            arr[l++]=h[k];
        }
        return smallSum;
    }
}

package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/8 20:55
 * @Version 1.0
 */
public class 红球放左边_蓝球方中间_黄球方右边 {
    // 类似于快排
    private void sort(int[] arr){
        int left = -1;
        int idx = 0;
        int right  = arr.length;
        while(idx<right){
            if(arr[idx]==0){ // 红球
                swap(arr,++left,idx++);
            }else if(arr[idx]==2){
                swap(arr,--right,idx);  // ****** 注意区别 // 右端换过来可能还是篮球或其他颜色，但左边换过来(不)是红球-因为left停留在不是红球的位置不动，可以直接++离开；
                                        // 模拟一下，左侧全红，右侧全蓝
            }else{
                idx++;//
            }
        }
    }
    private void swap(int[] a,int aa,int bb){

    }
}

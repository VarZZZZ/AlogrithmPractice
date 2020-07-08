package typical.array_程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/7 23:08
 * @Version 1.0
 */
public class 重排序_奇数下标是奇数_偶数下标是偶数 {
    //
    private void modify(int[] arr){
        int even = 0;
        int odd = 1;
        int end=arr.length-1;
        while(even<=end&&odd<=end){ // 从最后往前遍历，遇到奇数的，就直接替换掉前面奇数位置
            if((arr[end]&1)==0){
                int t = arr[even];
                arr[even] = arr[end];
                arr[end] = t;
                even +=2;
            }else{
                int t = arr[odd];
                arr[odd] = arr[end];
                arr[end] = t;
                odd +=2;
            }
        }
    }
}

package typical.array_2;

/**
 * @Author: ly
 * @Date: 2020/7/20 16:45
 * @Version 1.0
 */
public class 寻找重复数 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，
     * 其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
     *
     * 输入: [1,3,4,2,2]
     * 输出: 2
     */
    private int findDup(int[] arr){
        int slow = arr[0];
        int fast = arr[arr[0]];

        while(slow!=fast){
            slow = arr[slow];
            fast = arr[arr[fast]];
        }
        fast=0;
        while(slow!=fast){
            slow = arr[slow];
            fast = arr[fast];
        }
        return slow;
    }
}

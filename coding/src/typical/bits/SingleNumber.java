package typical.bits;

public class SingleNumber {
    //    这道题就是除了一个单独的数字之外，
//    数组中其他的数字都出现了三次，
//    还是要利用位操作 Bit Manipulation 来解。
//    可以建立一个 32 位的数字，来统计每一位上1出现的个数，
//    如果某一位上为1的话，那么如果该整数出现了三次，对3取余为0，
//    这样把每个数的对应位都加起来对3取余，最终剩下来的那个数就是单独的数字。
    //https://leetcode.com/problems/single-number-ii/
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int n : nums) {
                sum += (n >> i) & 1;
            }
            res |= (sum % 3) << i; // 得到多出来的1
        }
        return res;
    }

}

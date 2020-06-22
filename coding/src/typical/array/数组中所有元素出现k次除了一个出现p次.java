package typical.array;
// https://leetcode.com/problems/single-number-ii/discuss/43295/Detailed-explanation-and-generalization-of-the-bitwise-operation-method-for-single-numbers
public class 数组中所有元素出现k次除了一个出现p次 {


    // 数组中全部出现了2次，除了两个数字出现了1次，求出这两个数组
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for(int n:nums){
            diff ^=n;
        }
        // diff 现在为两个distinct 的值相异或。该结果必有一个1，因为两值不同
        diff &=-diff;  // 原码和补码相与。原码1表示不同，反码1表示相同， 原码与补码相与，只有1个bit为1，该位为两个distinct值的最后一//不同的bit
        int[] res = new int[]{0,0}; // 用3-5 测试一下；  补码为原码的除符号位，取反再加一；
        for(int n:nums){
            if((n&diff)==0){
                res[0]^=n;
            }else
                res[1]^=n;
        }
        return res;
    }

}


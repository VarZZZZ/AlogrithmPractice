package typical.array;

import java.util.Deque;
import java.util.LinkedList;

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
        Deque<Integer> qMax = new LinkedList<>();

        return res;
    }
    //在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
    public int singleNumber2(int[] nums) {
        if(nums.length==0) return -1;//输入数组长度不符合要求，返回-1;
        int[] bitSum = new int[32];//java int类型有32位，其中首位为符号位
        int res=0;
        for(int num:nums){
            int bitMask=1;//需要在这里初始化，不能和res一起初始化
            for(int i=31;i>=0;i--){//bitSum[0]为符号位
                //这里同样可以通过num的无符号右移>>>来实现，否则带符号右移(>>)左侧会补符号位，对于负数会出错。
                //但是不推荐这样做，最好不要修改原数组nums的数据
                if((num&bitMask)!=0) bitSum[i]++;//这里判断条件也可以写为(num&bitMask)==bitMask,而不是==1
                bitMask=bitMask<<1;//左移没有无符号、带符号的区别，都是在右侧补0
            }
        }
        for(int i=0;i<32;i++){//这种做法使得本算法同样适用于负数的情况
            res=res<<1;
            res+=bitSum[i]%3;//这两步顺序不能变，否则最后一步会多左移一次
        }
        return res;
    }
}


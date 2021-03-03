package typical.math;

/**
 * @Author: ly
 * @Date: 2020/8/23 21:34
 * @Version 1.0
 */
public class 区间内所有数字的按位与 {
    //对所有数字执行按位与运算的结果
    // 是所有对应二进制字符串的公共前缀再用零补上后面的剩余位。当不是公共字符后必然会有0-1不同，且其后面的数字位不会再出现相同的值
    //https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/shu-zi-fan-wei-an-wei-yu-by-leetcode-solution/
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m<<shift;

    }
}

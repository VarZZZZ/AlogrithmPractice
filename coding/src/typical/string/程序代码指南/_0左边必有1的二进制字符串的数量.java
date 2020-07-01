package typical.string.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/6/30 11:22
 * @Version 1.0
 */

public class _0左边必有1的二进制字符串的数量 {
    // 给定一个整数N，求有0 和1 组成的 长度为 N的字符串，满足0的左边必是1
    // 分析 设p(i) 为str[0...i-1]已经固定，且第i-1位为1的情况下，str[i..N-1]有多少种情况。
    // 第i位有可能为1或0，当为1时，则显然p(i+1),当为0时，第i+1位只能为1，不能为0，因为0的左边必须是1
    // 所以p(i)= p(i+1)+p(i+2)

    private int getNum(int n){
        if(n<1)
            return 0;
        if(n==1)
            return 1;
        int pre = 1;
        int cur = 1;
        int tmp = 0;
        for(int i=2;i<n+1;i++){
            tmp = cur;
            cur +=pre;
            pre = tmp;
        }
        return n+1;
    }
}

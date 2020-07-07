package typical.bits.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/2 23:03
 * @Version 1.0
 */
public class 不用而外变量交换两个整数_不做比较判断两个数的较大值 {
    //
    private void exchange(int a, int b) {
        a = a ^ b;
        b = a ^ b; // 得到了原来a的值
        a = a ^ b;

        // a=4=100;b=3=011,a^b=111=c;
        //  c^a = b

    }

    // 1. 得到a-b的符号；
}

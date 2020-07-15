package 笔试.tencent;

import java.util.LinkedList;

/**
 * @Author: ly
 * @Date: 2020/7/15 16:31
 * @Version 1.0
 */
public class 小Q的最小值序列 {
    /**
     * 小 Q 得到了一个长度为 n 的序列 A，A 中的数各不相同。对于 A 中的每一个
     * 数 Ai，求：min(1≤j<i)|Ai−Aj|
     *   以及令上式取到最小值的 j（记为 P_i）。若最小值点不唯一，则选择使 Aj 较小的那个。
     * 输入描述:
     * 第一行一个整数 n，第二行 n 个数。
     * 输出描述: n-1 行，每行 2 个用空格隔开的整数。分别表示当 i 取 2~n 时，对应的 min(1≤j<i)|Ai−Aj|和 Pi的值
     * 输入样例：
     * 3
     * 1 5 3
     * 输出样例：
     * 4 1
     * 2 1
     * @param args
     * 维护一个带有下标的有序链表结构；
     * 每一个数进入链表时，保证链表里的数下标都比他小，
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();


    }
}

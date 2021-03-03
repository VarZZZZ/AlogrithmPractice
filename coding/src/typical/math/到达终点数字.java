package typical.math;

/**
 * @Author: ly
 * @Date: 2020/8/26 11:40
 * @Version 1.0
 */
public class 到达终点数字 {
    /**
     * 在一根无限长的数轴上，你站在0的位置。终点在target的位置。
     * <p>
     * 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
     * <p>
     * 返回到达终点需要的最小移动次数。
     * <p>
     * 假设我们移动了 k 次，每次任意地向左或向右移动，那么最终到达的位置实际上就是将 1, 2, 3, ..., k 这 k 个数添加正号（向右移动）或负号（向左移动）后求和的值。
     * 并且如果最终到达的位置为 t 且 t < 0，那么我们可以将这 k 个数的符号全部取反，这样求和的值为 -t > 0。因此我们只考虑题目中 target > 0 的情况。
     * <p>
     * 我们沿用上面的符号，设 k 为最小的满足 S = 1 + 2 + ... + k >= target 的正整数，如果 S == target 那么答案显然是 k。
     * 如果 S > target，那么我们需要将一些正号变为负号，使得最后求和的值等于 target。
     */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int k = 0;
        while (target > 0) {
            target -= ++k;
        }
        return target % 2 == 0 ? k : k + 1 + k % 2;
    }
}

package typical.string;

/**
 * @Author: ly
 * @Date: 2020/8/10 10:05
 * @Version 1.0
 */
public class 计算01数量相等的子串个数 { // 连续子串


    // 10101=> 4个 ，10 01 10 01 ,(1010不是，这并不是连续的)
    /**
     * 方法1：将1的数量和v的数量统计
     */

    /**
     * 方法二：
     * 1.依次计数
     * 2.当不连续相等时，正在数的计数和上一次数的计数取最小;0000111, 符合要求子串为3个
     */
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int cnt = 0;
        int pre = 0;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                cnt += Math.min(pre, cur);
                pre = cur;
                cur = 1;
            }
        }
        return cnt + Math.min(pre, cur);
    }
}

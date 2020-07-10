package typical.string;

/**
 * @Author: ly
 * @Date: 2020/7/10 10:56
 * @Version 1.0
 */
public class N位数任意删除K个数字_使其最小 {
    /**
     * 假设k为1，最优解是删除出现的第一个左边大于右边的数，删除后高位变小
     */
    // 错误方法： 不能先遍历一次，求出所有的左边大于右边的数   如124682385 , k=2 ;该方法返回1246235，正确应该是1246235
    static String wrongDeleteNumK(String str, int k) {
        char[] chars = str.toCharArray();
        boolean[] f = new boolean[chars.length];
        int i1 = 0;
        for (; i1 < chars.length - 1 && k > 0; i1++) {
            if (chars[i1] > chars[i1 + 1]) {
                f[i1] = true;
                k--;
            }
        }
        int idx = 0;
        for (int i = 0; i < f.length; i++) {
            if (!f[i]) {
                chars[idx++] = chars[i];
            }
        }
        return new String(chars, 0, idx - k);

    }

    static String deleteNumK(String str, int k) {
        StringBuilder sb = new StringBuilder(str);
        boolean f;
        for (int i = k; i > 0; i--) {
            f = false;
            for (int i1 = 0; i1 < sb.length() - 1; i1++) {
                if (sb.charAt(i1) > sb.charAt(i1 + 1)) {
                    sb.deleteCharAt(i1);
                    f = true;
                    break;
                }
            }
            if (!f) { // 所有数字递增，则删除最后的数字
                sb.delete(sb.length() - i, sb.length());
                break;
            }
        }
        return sb.toString();
    }
}

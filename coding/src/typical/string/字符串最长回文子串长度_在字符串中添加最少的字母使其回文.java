package typical.string;

public class 字符串最长回文子串长度_在字符串中添加最少的字母使其回文 {
    //https://leetcode.com/problems/shortest-palindrome/discuss/60098/My-7-lines-recursive-Java-solution

    /**
     * 任意位置添加成回文
     */
    //如果可以在str的任意位置添加字符，则dp[i][j]表示str[i..j]最少添加几个字符可以使str[i...j]整体都是回文串
    // 如果str[i..j]只有一个字符，此时dp[i][j]=0
    // 如果str[i..j]只有两个字符，且相等，则dp[i][j]=0;如果不相等，则dp[i][j]=1;
    // 如果str[i..j]多余两个字符，且str[i]==str[j],则dp[i][j] = dp[i+1][j-1]..否则，先让str[i..j-1]符合要求，再到最左边添加str[j]
    // 所以dp[i][j] = min{dp[i][j-1],dp[i+1][j]} + 1

    /**
     * 尾部添加字符串成回文
     * s: hell ->sb1: helleh
     * 每次都在第4位置插入字符，首先插入h-> hellh, 判断是否是会问，再插入e=》helleh，判断是否是回文
     */
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        StringBuffer sb1 = new StringBuffer(s);
//        for (int i = 0; i < s.length()-1 && !isTrue(sb1.toString()); i++) {
//            sb1.insert(s.length(), s.charAt(i)); //
//        }
//        System.out.println(sb1); // 输出得到的最短字符串
//
//    }
//
//    public static boolean isTrue(String s) {  //判断是否回文
//        boolean flag = true;
//        for (int i = 0; i <= s.length() / 2; i++) {
//            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
//                flag = false;
//                break;
//            }
//        }
//        return flag;
//    }

    /**
     * 最长回文子串
     * 方法1.遍历字符，以每个字符为中心，向左右搜索
     */


}

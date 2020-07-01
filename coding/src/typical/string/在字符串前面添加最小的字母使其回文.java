package typical.string;

public class 在字符串前面添加最小的字母使其回文 {
    //https://leetcode.com/problems/shortest-palindrome/discuss/60098/My-7-lines-recursive-Java-solution


    //如果可以在str的任意位置添加字符，则dp[i][j]表示str[i..j]最少添加几个字符可以使str[i...j]整体都是回文串
    // 如果str[i..j]只有一个字符，此时dp[i][j]=0
    // 如果str[i..j]只有两个字符，且相等，则dp[i][j]=0;如果不相等，则dp[i][j]=1;
    // 如果str[i..j]多余两个字符，且str[i]==str[j],则dp[i][j] = dp[i+1][j-1]..否则，先让str[i..j-1]符合要求，再到最左边添加str[j]
    // 所以dp[i][j] = min{dp[i][j-1],dp[i+1][j]} + 1
}

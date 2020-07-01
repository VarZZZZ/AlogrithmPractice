package typical.string.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/1 22:32
 * @Version 1.0
 */
public class 找到字符串的最长无重复字符子串 {

    // 1.遍历str前，先申请几个变量，哈希表map,key表示某个字符，value为这个字符最近一次出现的位置。
    // 如果当前遍历到字符str[i],pre表示在必须以str[i-1]为结尾的情况下，最长无重复字符串的开始位置的前一个位置。

    private int maxUnique(String str){
        char[] chas = str.toCharArray();
        int[] map = new int[256];
        for(int i=0;i<256;i++){
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for(int i=0;i<chas.length;i++){
            pre = Math.max(map[chas[i]],pre); // 首先原pre...i-1之间无重复
            cur = i - pre;
            len = Math.max(len,cur);
            map[chas[i]] = i;
        }
        return len;
    }
}

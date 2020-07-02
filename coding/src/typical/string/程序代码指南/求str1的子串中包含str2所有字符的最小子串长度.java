package typical.string.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/1 23:14
 * @Version 1.0
 */
public class 求str1的子串中包含str2所有字符的最小子串长度 {
    // 依旧是滑动窗口
    private int minLength(String str1,String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int[] map = new int[256];
        for(char c:chars2){
            map[c]++;
        }

        int left = 0;
        int right = 0;
        int match = chars2.length;
        int minRes = Integer.MAX_VALUE;

        for(int i=0;i<chars1.length;i++){
            map[chars1[i]]--;
            if(map[chars1[i]]>=0){
                match--;
            }
            if(match==0){ // 所有字符都匹配到了
                while(map[chars1[left]]<0){
                    map[chars1[left++]]++; // 最左边的不合要求的，超过了str2字符所需的，往后右移。
                } // 即时是重复的也可以右移掉
                minRes = Math.max(minRes,i-left+1);
                match++; // 此时的left到i是当前符合要求的，map[left]=0,往后滑动一位，找其他最小的窗口
                map[chars1[left++]]++;
            }
        }
        return minRes==Integer.MAX_VALUE?0:minRes;

    }
}

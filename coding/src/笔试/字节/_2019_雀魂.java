package 笔试.字节;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/7/15 17:31
 * @Version 1.0
 */
public class _2019_雀魂 {
    // 硬做，先判断刻子，再判断顺子
    // 一个一个试着填进去，然后寻找雀头，在寻找刻字和顺子
    // https://blog.csdn.net/weixin_43866076/article/details/100725404
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        for(int i=0;i<13;i++){
            int cur = sc.nextInt();
            num[cur]++;
        }

    }
}

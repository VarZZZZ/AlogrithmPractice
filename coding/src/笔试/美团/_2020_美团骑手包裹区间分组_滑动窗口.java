package 笔试.美团;

import java.util.*;

public class _2020_美团骑手包裹区间分组_滑动窗口 {
    //2110年美团外卖火星第3000号配送站点有26名骑手，分别以大写字母A-Z命名，因此可以称呼这些骑手为黄家骑士特工A，黄家骑士特工B…黄家骑士特工Z，
    // 某美团黑珍珠餐厅的外卖流水线上会顺序产出一组包裹，美团配送调度引擎已经将包裹分配到骑手，
    // 并在包裹上粘贴好骑手名称，如RETTEBTAE代表一组流水线包裹共9个，同时分配给了名字为A B E R T的5名骑手。
    // 请在不打乱流水线产出顺序的情况下，把这组包裹划分为尽可能多的片段，同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。

    // 其实类似于区间，找到最多的不相交的个数
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        //典型的滑动窗口，先判断当前字符的最后一个位置在哪，在不断的更新另一个指针使得开始指针与结尾指针满中间没有的元素在后面不会出现。
        int i=0,j=0,len=str.length();
        while(j<len){
            char c = str.charAt(j);
            int tail = str.lastIndexOf(c);
            int pre = j;
            i = j+1;
            j = tail;
            while(i<j){
                char inner = str.charAt(i);
                j = Math.max(j, str.lastIndexOf(inner));
                i++;
            }
            j++;
            System.out.print(j-pre+" ");
        }
    }
}

package typical.array_程序代码指南;

import java.util.PriorityQueue;

/**
 * @Author: ly
 * @Date: 2020/7/8 21:30
 * @Version 1.0
 */
public class 分金条的最小花费_哈夫曼 {
    // 给定数组arr，累加和表示金条的长度，每个数表示金条需要分成的长度，规定长度为K的金条只能分成两块，费用为K，为分成数组中每个数的最小代价
    // arr [ 10,30,20]   可以想分成30 和30，花费60，在从30的金条中分成10和20，花费30，最小。
    // 类似于哈夫曼
    // 假设最小代价ans,初始ans=0,将  arr 所有数字放入小根堆
    // 从小更对弹出两个数字，假设为a和b，令ans = ans+a+b,然后把a+b的和放入小根堆。重复操作
    // 虽然是先去最小的两个，但是实际上是最后再划分这两个

    private int getMinSplit(int[] arr){
        if(arr==null||arr.length<2) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.offer(a);
        }
        int ans = 0;
        while(pq.size()!=1){
            int sum = pq.poll() + pq.poll();
            ans +=sum;
            pq.offer(sum);
        }
        return ans;
    }
}

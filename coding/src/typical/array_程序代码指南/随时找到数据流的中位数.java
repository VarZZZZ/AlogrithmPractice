package typical.array_程序代码指南;

import java.util.PriorityQueue;

/**
 * @Author: ly
 * @Date: 2020/7/9 10:12
 * @Version 1.0
 */
public class 随时找到数据流的中位数 {
    /**
     * 利用大小堆实现
     * 小根堆保存数组的较大一半的数，大根堆保存数组的较小一半的数
     * 1.第一个数直接进入大根堆
     * 2.新加一个数，判断cur是否小于或等于大根堆的堆顶，如果是，则加入大根堆，否则，加入小根堆
     * 3.每次加入完后，判断两个堆之间的size大小，如果相差超过了1，则poll size大的放入size小的
     * 4.任何时候想要中位数，从两个堆的堆顶获得即可
     */
    class Median{
        private PriorityQueue<Integer> maxHeap;
        private PriorityQueue<Integer> minHeap;

        public Median(){
            maxHeap = new PriorityQueue<>((a,b)->(b-a));
            minHeap = new PriorityQueue<>();
        }
        private void addNum(int n){
            if(maxHeap.size()==0||n>=maxHeap.peek()){
                maxHeap.offer(n);
            }else{
                minHeap.offer(n);
            }
            if(maxHeap.size()==minHeap.size()+2){
                minHeap.offer(maxHeap.poll());
            }
            if(minHeap.size()==maxHeap.size()+2){
                maxHeap.offer(minHeap.poll());
            }
        }
        int getMedian(){
            if(maxHeap.size()==minHeap.size()){
                return (maxHeap.peek()+minHeap.peek())/2;
            }else{
                return maxHeap.size()>minHeap.size()?maxHeap.peek():minHeap.peek();
            }
        }
    }
}

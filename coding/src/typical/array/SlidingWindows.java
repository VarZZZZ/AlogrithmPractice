package typical.array;

import java.util.*;
import java.util.function.Supplier;

public class SlidingWindows {
    public static void main(String[] args) {
        SlidingWindows s = new SlidingWindows();
        double[] res = s.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
        for(double d:res){
            System.out.println(d);
        }
    }
    static class MyInteger{
        int val;
        int index;

        public MyInteger(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    // 找到nums 中  以k为大小的窗口  的中数,并滑动
    public double[] medianSlidingWindow(int[] nums, int k) {
        // 两个treeset都是从小到大；  first 负责前部分； second负责后半；将8,1,5,3,4,2窗口分为  1 ,2 ,3 : first;  4,5,8: second;如果k=6
        TreeSet<MyInteger> firstHeap = new TreeSet<>(new Comparator<MyInteger>(){
            public int compare(MyInteger a,MyInteger b){
                if(a.val!=b.val){
                    if(a.val<b.val){
                        return -1;
                    }else{
                        return 1;
                    }
                }else{
                    return a.index-b.index;
                }
            }
        });
        TreeSet<MyInteger> secondHeap = new TreeSet<>((a,b)->a.val!=b.val?a.val-b.val:a.index-b.index);
        Deque<MyInteger> deque = new ArrayDeque<>();
        double[] res = new double[nums.length-k+1];
        for(int i=0;i<k;i++){
            MyInteger z = new MyInteger(nums[i],i);
            deque.offer(z);
            firstHeap.add(z);
        }
        balance(firstHeap,secondHeap);
        res[0] = getMedian(firstHeap,secondHeap);
        int p=1;
        for(int i=k;i<nums.length;i++){
            MyInteger z = deque.pollFirst();
            if(secondHeap.contains(z)){
                secondHeap.remove(z);
            }else{
                firstHeap.remove(z);
            }
            MyInteger newZ =new MyInteger(nums[i],i);
            deque.offer(newZ);
            secondHeap.add(newZ);
            firstHeap.add(secondHeap.pollFirst());
            balance(firstHeap,secondHeap);
            res[p++] = getMedian(firstHeap,secondHeap);
        }
        return res;
    }

    private void balance(TreeSet<MyInteger> firstHeap,TreeSet<MyInteger> secondHeap){
        while(firstHeap.size()>secondHeap.size()){
            secondHeap.add(firstHeap.pollLast());
        }
        while(firstHeap.size()<secondHeap.size()-1){
            firstHeap.add(secondHeap.pollFirst());
        }
    }
    private double getMedian(TreeSet<MyInteger> firstHeap,TreeSet<MyInteger> secondHeap){
        if(firstHeap.size()<secondHeap.size()){
            return (double)secondHeap.first().val;
        }
        return ((double)firstHeap.last().val+(double)secondHeap.first().val)/2.0;
    }


    // 求一维数组， 窗口大小为w的 最大值 序列;
    private int[] getMaxWindow(int[] arr,int w){
        LinkedList<Integer> qmax = new LinkedList<>();  // 保存窗口大小，其中，peekFirst是当前窗口内值最大的下标；同时也是最左边的下标
        int[] res = new int[arr.length-w+1];
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            while(!qmax.isEmpty()&&arr[qmax.peekLast()]<=arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i); // qmax 从大到小(指的是ar[i])
            if(qmax.peekFirst()==i-w){ //窗口右移，如果当前最大值为应该移掉的值
                qmax.pollFirst();
            }
            if(i>=w-1){ //在i>=w-1之后，每一个循环都需要添加一个res[idx]
                res[i-w+1] = qmax.peekFirst();
            }
        }
        return res;

    }
}

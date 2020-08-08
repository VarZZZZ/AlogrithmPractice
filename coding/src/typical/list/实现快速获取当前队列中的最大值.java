package typical.list;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: ly
 * @Date: 2020/8/7 11:51
 * @Version 1.0
 */
public class 实现快速获取当前队列中的最大值 {
    class MaxQueue {
        Deque<Integer> res;
        Deque<Integer> maxQ;
        public MaxQueue() {
            res = new LinkedList<>();
            maxQ = new LinkedList<>();
        }

        public int max_value() {
            if(maxQ.isEmpty()) return -1;
            return maxQ.peek();
        }

        public void push_back(int value) {
            res.offer(value);
            while(!maxQ.isEmpty()&&maxQ.peekLast()<value) maxQ.pollLast();
            maxQ.offer(value);
        }

        public int pop_front() {
            if(res.isEmpty()) return -1;
            int tp = res.poll();
            if(tp==maxQ.peek()) maxQ.poll();
            return tp;
        }
    }

}

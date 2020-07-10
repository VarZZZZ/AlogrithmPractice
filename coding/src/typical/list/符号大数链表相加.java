package typical.list;

import java.util.Stack;

/**
 * @Author: ly
 * @Date: 2020/7/10 11:28
 * @Version 1.0
 */
public class 符号大数链表相加 {
    class Node {
        char value;
        Node next;

        Node(char value) {
            this.value = value;
        }
    }

    /**
     * 利用栈结构
     */
    Node addListWithStack(Node l1, Node l2) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        char c1 = l1.value;
        char c2 = l2.value;
        int t1 = c1 == '+' ? 1 : -1;
        int t2 = c2 == '+' ? 1 : -1;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null) {
            s1.push(l1.value);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.value);
            l2 = l2.next;
        }

        Node node = null;
        Node pre = null;

        int cur1 = 0, cur2 = 0, curSum = 0;
        int p = 0;//进位
        while (!s1.empty() || s2.empty()) {
            cur1 = s1.empty() ? 0 : t1 * s1.pop();
            cur2 = s2.empty() ? 0 : t2 * s2.pop();
            curSum = cur1 + cur2 + p;

            int curSumWithNoSign = Math.abs(curSum);

            pre = node;
            node = new Node((char) (curSumWithNoSign % 10));
            node.next = pre;

            p = curSumWithNoSign / 10;
            if (curSum < 0) p = -p;

        }
        if(p!=0){
            pre = node;
            node = new Node('1');
            node.next = pre;

            pre = node;
            node = new Node(p>0?'+':'-');
            node.next = pre;
        }
        return node;
    }




}

import java.util.*;

public class Main {


//    class Solution {
//        public String reverseParentheses(String s) {
//            Stack<Character> st = new Stack<>();
//            List<Character> ls = new ArrayList<>();
//            for (int i = 0; i < s.length(); i++) {
//                if (s.charAt(i) == ')') {
//                    while (st.peek() != '(') {
//                        ls.add(st.pop());
//                    }
//                    st.pop();
//                    for (int c = 0; c < ls.size(); c++) {
//                        st.push(ls.get(c));
//                    }
//                    ls.clear();
//                } else {
//                    st.push(s.charAt(i));
//                }
//            }
//            StringBuilder sb = new StringBuilder();
//            while (!st.isEmpty()) {
//                sb.append(st.pop());
//            }
//            return sb.reverse().toString();
//        }
//    }

    class Node {
        int data;
        Node next;
    }

    class Solution {
        public Node mergeTwoLists(Node n1, Node n2) {
            if (n1 == null) return n2;
            if (n2 == null) return n1;
            Node head = n1.data < n2.data ? n1 : n2;
            Node pre = head;
            Node p = pre.next;
            Node q = head == n1 ? n2 : n1;
            while (p != null && q != null) {
                if (p.data <= q.data) {
                    pre = p;
                    p = p.next;
                } else {
                    Node next = q.next;
                    q.next = p;
                    pre.next = q;
                    pre = pre.next;
                    q = next;
                }
            }
            pre.next = q == null ? p : q;
            return head;
        }
    }


}



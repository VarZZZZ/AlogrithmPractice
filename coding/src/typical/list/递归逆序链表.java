package typical.list;

import java.util.ArrayList;

public class 递归逆序链表 {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
   }
   private ListNode reverseList(ListNode head){
        return cat(head,null);
   }
   private ListNode cat(ListNode head,ListNode tail){
        if(head==null) return tail;
        ListNode next = head.next;
        head.next=tail;
        return cat(next,head);
   }

   //每k个节点逆序一次; 还有方法就是直接算，从头遍历，遍历到k倍数时，便记录链表的左右，另外用函数去处理这一截
   public ListNode reverseKGroup(ListNode head, int k) {
       ListNode cur = head;
       int count = 0;
       while(cur !=null && count !=k){
           cur = cur.next;
           count++;
       }
       if(count==k){
           cur = reverseKGroup(cur,k);

           while(count-->0){
               ListNode next = head.next;
               head.next = cur;
               cur = head;
               head = next;
           }
           head = cur;  //*****
       }
       return head;
   }

    /**
     * 递归 从尾遍历单链表
     */
    ArrayList<Integer> res = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null) return res;
        res = printListFromTailToHead(listNode.next);
        res.add(listNode.val);
        return res;

    }

}

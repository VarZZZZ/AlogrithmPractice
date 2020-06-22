package typical.list;
import java.util.*;
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
public class K_有序链表合并 {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists,0,lists.length-1);
    }

    private ListNode partition(ListNode[] lists,int s,int e){
        if(s == e) {
            return lists[s];
        }
        if(s < e){
            int q = (s + e)/2;
            ListNode l1 = partition(lists,s,q);
            ListNode l2 = partition(lists,q+1,e);

            return merge(l1,l2);

        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l1,ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val < l2.val){
            l1.next = merge(l1.next,l2);
            return l1;
        } else{
            l2.next = merge(l1,l2.next);
            return l2;
        }
    }
    private ListNode merge_2(ListNode l1,ListNode l2){
        ListNode head = l1.val<l2.val?l1:l2;
        ListNode cur1 = head==l1?l1:l2;
        ListNode cur2 = head==l1?l2:l1;
        ListNode pre=null,next=null;
        while(cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
                pre = cur1;
                cur1=cur1.next;
            }else{
                next = cur2.next;
                pre.next=cur2;
                cur2.next=cur1;
                pre = cur2;
                cur2=next;
            }
        }
        pre.next=cur1==null?cur2:cur1;
        return  head;
    }
}

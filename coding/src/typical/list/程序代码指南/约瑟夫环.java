package typical.list.程序代码指南;

/**
 * @Author: ly
 * @Date: 2020/7/1 22:56
 * @Version 1.0
 */
public class 约瑟夫环 {
    //N个人围成一圈，从第一个人开始报数，报到m的人出圈，
    // 剩下的人继续从1开始报数，报到m的人出圈；如此往复，直到所有人出圈。（模拟此过程，输出出圈的人的序号）

    class Node{
        int val;
        Node next;
        Node(int v){
            val=v;
        }
    }

    private Node josephusKill(Node head,int m){
        if(head==null||head.next==head||m<1) return head;
        Node last = head;
        while(last.next!=head){
            last=last.next;
        }
        int cnt = 0;
        while(head!=last){
            if(++cnt==m){
                last.next=head.next;
                cnt=0;
            }else{
                last=last.next;
            }
            head = last.next;
        }
        return head;
    }
}

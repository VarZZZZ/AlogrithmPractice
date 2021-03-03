package typical.HashTable;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFU_LRU {

    // put 新key ，设置min=1;put已有的key和get 需要更新key的访问频率
    class LFUCache {
        private Map<Integer,Integer> keyValue;
        private Map<Integer,Integer> keyCnt;
        private Map<Integer, Set<Integer>> cntKey;
        int min = -1;
        int capacity = 0;


        public LFUCache(int capacity) {
            keyValue = new HashMap<>();
            keyCnt = new HashMap<>();
            cntKey = new HashMap<>();
            cntKey.put(1,new LinkedHashSet<>());
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!keyValue.containsKey(key)){
                return -1;
            }
            int cnt = keyCnt.get(key);
            keyCnt.put(key,cnt+1);
            cntKey.get(cnt).remove(key);
            if(cnt==min && cntKey.get(cnt).size()==0){ // 如果访问的是频率最小的key，且频率最小的key只有这一个，那么提升最小频率
                min++;
            }
            if(!cntKey.containsKey(cnt+1)){
                cntKey.put(cnt+1,new LinkedHashSet<>());
            }
            cntKey.get(cnt+1).add(key);
            return keyValue.get(key);
        }

        public void put(int key, int value) {
            if(capacity<=0)
                return;
            if(keyValue.containsKey(key)){
                keyValue.put(key,value);
                get(key);
                return;
            }
            if(keyValue.size()>=capacity){
                int rvk = cntKey.get(min).iterator().next();
                cntKey.get(min).remove(rvk);
                keyValue.remove(rvk);
                keyCnt.remove(rvk);
            }
            keyValue.put(key,value);
            min = 1;
            keyCnt.put(key,min);
            cntKey.get(min).add(key);
        }
    }

    class LRUCache{
        private int capacity;
        private DLinkNode head,tail;
        private int count;
        private Map<Integer,DLinkNode> map = new HashMap<>();
        class DLinkNode{
            int key;
            int value;
            DLinkNode pre;
            DLinkNode next;
        }
        // 4个基本方法：添加节点、移除节点、移动节点到head、remove最后节点
        private void addNode(DLinkNode node){
            node.pre=head;
            node.next=head.next;
            head.next.pre=node;
            head.next=node;
        }
        private void removeNode(DLinkNode node){
            node.next.pre=node.pre;
            node.pre.next=node.next;
        }
        private void moveToHead(DLinkNode node){
            this.removeNode(node);
            this.addNode(node);
        }
        private DLinkNode popTail(){
            DLinkNode tail = this.tail.pre;
            this.removeNode(tail);
            return tail;
        }
        public LRUCache(int capacity){
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.pre=null;
            tail.next=null;
            head.next=tail;
            tail.pre=head;
        }
        public int get(int key){
            DLinkNode n = map.get(key);
            if(n!=null){
                moveToHead(n);
                return n.value;
            }else{
                return -1;
            }
        }
        private void put(int key,int val){  // LFU LRU都是在put时删除节点
            DLinkNode n = map.get(key);
            if(n==null){
                DLinkNode node = new DLinkNode();
                node.key=key;
                node.value=val;
                addNode(node);
                map.put(key,node);
                count++;
                if(count>this.capacity){   // 删两个-先删链表，再删Map
                    DLinkNode tail=this.popTail();
                    this.map.remove(tail.key);
                    count--;
                }
            }else{
                n.value=val;
                moveToHead(n);
            }
        }

    }



}

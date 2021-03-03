package typical.must_member;

import java.util.Objects;

/**
 * @Author: ly
 * @Date: 2020/9/1 22:24
 * @Version 1.0
 *
 * 简易版hashmap
 */
public class HashMap_Self {
    class Node{
        final int hash;
        final int key;
        int val;
        Node next;
        Node(int hash,int key,int val,Node next){
            this.hash=hash;
            this.key=key;
            this.val = val;
            this.next = next;
        }
        int getKey() {return key;}
        int getVal() {return val;}
        int setValue(int newVal){
            int old = val;
            val = newVal;
            return old;
        }

        //1. 重写hashCode 和equals
        public final int hashCode() {
            return Objects.hashCode(key)^Objects.hashCode(val);
        }
        public final boolean equals(Object o){
            if (o==this){
                return true;
            }
            Node n = (Node)o;
            if(n.key==key&&n.val==val){
                return true;
            }else{
                return false;
            }
        }
    }



    Node[] table; //2. 元素表 ------------------------
    int size; // 存放元素的个数
    int modCount; //被修改的次数fast-fail机制
    int threshold; //临界值
    int loadFactor; // 填充比

    HashMap_Self(){
    }

    final int hash(Object key) {   //jdk1.8 & jdk1.7
        int h;
        // h = key.hashCode() 为第一步 取hashCode值
        // h ^ (h >>> 16)  为第二步 高位参与运算
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    int get(int key){
        int hash = hash(key);

        Node[] tab;
        Node first,e; //在tab数组中经过散列的第一个位置
        int n;
        int k;
        if((tab=table)!=null&& (n=tab.length)>0 &&(first=tab[(n-1)&hash])!=null){
            if(first.hash==hash && ((k = first.key) == key)){ // 确定找到，是首先hash相同，然后key相同
                return first.val;
            }
            // 查链表
            if ((e=first.next)!=null){
                do{
                    if(e.hash==hash && ((k = e.key) == key)){
                        return e.val;
                    }
                }while ((e = e.next) != null);
            }
        }
        return 0;
    }

    int put(int key,int val){ // 返回旧值
        int hash = hash(key);
        Node[] tab;
        Node p;
        int n,i;
        tab = table;
        n = tab.length;

        if((p=tab[i = (n-1)&hash]) == null){
            tab[i] = new Node(hash,key,val,null);
        }else{
            Node e;
            int k;
            // 先获取Node，如果遍历Node为null(为null则新建)或者找到相同的Key，break。
            if( p.hash ==hash&& ((k=p.key)==k)){
                e = p;
            }else{

            }
        }
        return 0;

    }





}

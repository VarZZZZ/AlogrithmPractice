package typical.array.程序代码面试指南;

import java.util.Enumeration;

/**
 * @Author: ly
 * @Date: 2020/7/2 10:24
 * @Version 1.0
 */
public class 子数组的最大异或和 {
    //分析 设eor[i] 为arr[0...i]的异或和，
    // 则以arr[j]结尾的最大异或和max = eor[j]^(0,eor[0],eor[1],,,eor[j-1]中调一个出来)。形成子数组异或和。
    // 以trieTree分析。每个节点有两条分支，表示0和1，
    //p 326
    // 假设 要求max ,j=5的情况，已知eor[4]..eor[0],将eor[0..4] 构成trie树。
    // 在知道eor[5]的二进制的情况下，希望从树中找到尽可能高位相反的树路径
    // 如eor[5]=0110,希望找到1001,从而使异或和最大
    class Node{
        Node[] next= new Node[2];
    }
    class NumTrie{
        Node head =new Node();
        void add(int newNum){
            Node cur = head;
            for(int i=31;i>=0;i--){
                int next = ((newNum>>i)&1);
                cur.next[next] = cur.next[next]==null?new Node():cur.next[next];
                cur = cur.next[next];
            }
        }

        // 求以当前eorj为结尾的最大异或和
        int maxXor(int eorj){
            Node cur = head;
            int res = 0;
            for(int i = 31;i>=0;i--){
                int path = ((eorj>>i)&1);
                int best = i==31?path:(path^1); // 当前应该选择的最佳理想路径，最高位是符号位，应变成0；
                best = cur.next[best]==null?(best^1):best; // 尽量选择的路径(此路径是之前的eor[j]，如果当前没有，则必然有一条相反的路径，只能从该路径走
                res |= (path^best) << i;      // 进行异或
                cur = cur.next[best];
            }
            return res;
        }

        private int maxXorSubarray(int[] arr){
            int max = Integer.MIN_VALUE;int eor = 0;
            NumTrie t = new NumTrie();
            t.add(0);
            for(int j=0;j<arr.length;j++){
                eor ^= arr[j];
                max = Math.max(max,t.maxXor(eor));
                t.add(eor);
            }
            return max;
        }
    }
}

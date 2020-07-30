package typical.Tree;

public class ___查找第k个字典序的字符串 {
    //https://leetcode.com/submissions/detail/272807927/
    /**
     * Given integers n and k,
     * find the lexicographically k-th smallest integer in the range from 1 to n.
        Input:
        n: 13   k: 2
        Output:
        10
     */
    private int findKthNum(int n,int k){
        int cur = 1;
        k = k-1;
        while(k>0){
            int step = calStep(n,cur,cur+1);
            if(step<=k){
                k -=step;
                cur ++;
            }else{
                cur *=10;
                k--;
            }
        }
        return cur;
    }
    private int calStep(int n, int n1, int n2) {
        int step =  0;
        while(n1<=n){
            step += Math.min(n+1,n2)-n1; // 当在第2层时，n=13,n2=20,n1=10;
            n1 *=10;
            n2 *=10;
        }
        return step;
    }


}

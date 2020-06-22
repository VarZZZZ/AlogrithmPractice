package typical.string;

public class 消消乐 {
    int MAXBALL=6;

    //找到最小插入board中，从而消除Board字符串的次数
    public int findMinStep(String board, String hand) {
        int[] hcnt = new int[26];
        for(char c:hand.toCharArray()){
            hcnt[c-'A']++;
        }
        int res = helper(board+"#",hcnt);
        return res==MAXBALL?-1:res;

    }
    private int helper(String board,int[] hcnt){
        board = remove(board);
        if(board.equals("#")) return 0;
        int cnt = MAXBALL;
        for(int i=0,j=0;j<board.length();j++){
            if(board.charAt(i)==board.charAt(j)) continue;
            int need = 3-(j-i);
            if(hcnt[board.charAt(i)-'A']>=need){
                hcnt[board.charAt(i)-'A']-=need;
                // 因为可以一条路走到底；所以dfs可以在for循环里面 求最小;
                cnt = Math.min(cnt,need+helper(board.substring(0,i)+board.substring(j),hcnt));
                hcnt[board.charAt(i)-'A']+=need;
            }
            i=j;
        }
        return cnt;
    }
    // 重要 消除字符串中3个及以上的字符串；消消乐的方式
    private String remove(String board){
        for(int i=0,j=0;j<board.length();j++){
            if(board.charAt(i)==board.charAt(j)) continue;
            if(j-i>=3){
                return remove(board.substring(0,i)+board.substring(j));
            }
            i=j;
        }
        return board;
    }
}

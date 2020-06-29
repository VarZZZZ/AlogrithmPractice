package 笔试.美团;

import java.util.*;

//已知一种新的火星文的单词由英文字母（仅小写字母）组成，但是此火星文中的字母先后顺序未知。
// 给出一组非空的火星文单词，且此组单词已经按火星文字典序进行好了排序（从小到大），
// 请推断出此火星文中的字母先后顺序
public class _2020_火星文字典 {

    // 利用topology保持序列
    private static int[][] map = new int[26][26]; // 如果i在j的前面，则map[i][j]=1;

    private static int[] inDegree = new int[26];

    private static boolean[] flag = new boolean[26];
    private static Set<Character> st= new HashSet<>();

    private static List<Character> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] input = str.split(" ");

        build(input);
        topology();

    }
    private static void build(String[] input){
        String pre = input[0];
        for(int i=0;i<pre.length();i++){
            st.add(pre.charAt(i));
        }

        for(int j=1;j<input.length;j++){
            String cur = input[j];
            for(char c:cur.toCharArray()){
                st.add(c);
            }
            for(int i=0;i<Math.min(cur.length(),pre.length());i++){
                if(cur.charAt(i)==pre.charAt(i)) continue;
                if(map[pre.charAt(i)][cur.charAt(i)]==1) break; // 当前pre cur是靠idx i 排好序的，且已经排好了
                map[pre.charAt(i)][cur.charAt(i)]=1;
                inDegree[cur.charAt(i)]++;
                flag[pre.charAt(i)]=true;
                flag[cur.charAt(i)]=true;
                break;
            }
            pre = cur;
        }
    }
    private static void topology(){
        while(ans.size()<st.size()){
            int cnt = 0;
            for(int i=0;i<26;i++){
                if(inDegree[i]==0&&flag[i]) cnt++;
            }
            if(cnt!=1) return; //入度为0的cnt只能为1
            for(int i=0;i<26;i++){              // 该for只能往后遍历，有可能在下一个for循环中使前面的indegree--=0了，所以需要while
                if(inDegree[i]==0&&flag[i]){
                    flag[i]=false;
                    ans.add((char)(i+'a'));
                    for(int j=0;j<26;j++){
                        if(map[i][j]==1){
                            inDegree[j]--;
                            map[i][j]=0;
                        }
                    }
                }
            }


        }
    }

}



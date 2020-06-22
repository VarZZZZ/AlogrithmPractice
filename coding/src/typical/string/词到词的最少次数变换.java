package typical.string;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/
public class 词到词的最少次数变换 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 先bfs，找到最短的层次，后面路径长的层次直接丢弃
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> neighbor = new HashMap<>();
        Map<String,Integer> distance  = new HashMap<>();
        distance.put(beginWord,0);
        wordList.add(beginWord);
        bfs(beginWord,endWord,wordList,neighbor,distance);
        dfs(beginWord,endWord,neighbor,distance,res,new ArrayList<>());
        return res;
    }
    private void bfs(String begin,String end,List<String> wordList,Map<String,List<String>> neighbor,
                     Map<String,Integer> distance){
        for(String w:wordList){
            neighbor.put(w,new ArrayList<>());
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(begin);
        boolean f = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                String cur = queue.poll();
                int pre_dis = distance.get(cur);
                List<String> nei = getNeighbor(cur,wordList);
                for(String n:nei){
                    neighbor.get(cur).add(n);
                    if(!distance.containsKey(n)){
                        distance.put(n,pre_dis+1);
                        if(n.equals(end)){
                            f=true;
                        }else{
                            queue.offer(n);
                        }
                    }
                }
                if(f) break;
            }
        }
    }

    private void dfs(String cur,String end,Map<String,List<String>> neighbor,
                     Map<String,Integer> distance,List<List<String>> res,List<String> tmp){
        if(cur.equals(end)){
            res.add(new ArrayList<>(tmp));
        }else{
            for(String n:neighbor.get(cur)){
                if(distance.get(n)==distance.get(cur)+1) {
                    tmp.add(n);
                    dfs(n, end, neighbor, distance, res, tmp);
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private List<String> getNeighbor(String word,List<String> wordList){
        List<String> res = new ArrayList<>();
        char[] wc = word.toCharArray();
        for(char ch='a';ch<='z';ch++){
            for(int i=0;i<wc.length;i++){
                if(ch==wc[i]) continue;
                char old = wc[i];
                wc[i] = ch;
                if(wordList.contains(String.valueOf(wc))){
                    res.add(String.valueOf(wc));
                }
                wc[i]=old;
            }
        }
        return res;
    }
}

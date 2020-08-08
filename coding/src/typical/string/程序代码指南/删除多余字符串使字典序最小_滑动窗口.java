package typical.string.程序代码指南;

public class 删除多余字符串使字典序最小_滑动窗口 {
    // str = 'acbc' =》'abc'

    // str有k个不同的字符，即选出res[k]长度的结果。 str='baacbaccac'
    // 建立str 的字符词频统计
    // 2.从左往右遍历，遍历到字符，对应频数就减一，当发现为0,时，就停止，此时，从该窗口中选出一个最小的字典序当做res[0..i]
    // 3. 在str[0..4]上找到最小字符，str[1]='a',res[0]
    // 4.在挑选str[1]的右边，字符串为'acbaccac'，删除“a',的str='cbccc',继续从这里面找res[1]

    private String removeDuplicateLetter(String s){  // 该版本有问题
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        for(char c:str){
            cnt[c-'a']++;
        }
        char[] res = new char[26];
        int idx = 0;
        int L = 0;
        int R = 0;
        while(R!=str.length){
            if(cnt[str[R] - 'a'] != 1){
                R++;
                if(cnt[str[R]-'a']!=-1) // 过滤掉已经选择了的字符
                    cnt[str[R]-'a']--;
            }else{
                cnt[str[R]-'a']--;
                int pick = -1;
                for(int i=L;i<=R;i++){
                    if(pick == -1 || str[i] < str[pick]){
                        pick = i;
                    }
                }
                res[idx++] = str[pick]; //就算没选字符频数为0的也不要紧， 因为它会在后面的字符串中再出现
                cnt[str[pick]-'a'] = -1; // 不再考虑他了
                for(int i=pick+1;i<=R;i++){
                    if(cnt[str[i]-'a']!=-1)
                        cnt[str[i]-'a']++;
                }

                L = pick+1;
                R = L;         // 窗口回退，窗口的大小减为1
            }
        }
        return String.valueOf(res,0,idx);
    }

    public String removeDuplicateLetters(String s) {
        int[] map  = new int[26];
        int pre=-1;
        StringBuilder sb = new StringBuilder();
        int l=0,r=0;
        char[] sc = s.toCharArray();
        for(int i=0;i<sc.length;i++){
            map[sc[i]-'a']++;
        }
        char[] res=  new char[26];
        int idx=0;
        while(r<sc.length){
            if(map[sc[r]-'a']!=1){
                if(map[sc[r]-'a']!=-1){
                    map[sc[r]-'a']--;
                }
                r++;
            }else{
                map[sc[r]-'a']--;
                int pick = -1;
                for(int i=l;i<=r;i++){
                    if(map[sc[i]-'a']==-1) continue; // 必须需要
                    if(pick==-1||sc[pick]>sc[i]){
                        pick = i;
                    }
                }
                res[idx++]=sc[pick];
                map[sc[pick]-'a']=-1;
                for(int i=pick+1;i<=r;i++){
                    if(map[sc[i]-'a']!=-1)
                        map[sc[i]-'a']++;
                }
                l=pick+1;
                r=l;
            }
        }
        return new String(res,0,idx);

    }
}

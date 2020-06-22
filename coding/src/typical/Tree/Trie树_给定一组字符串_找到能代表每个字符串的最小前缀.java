package typical.Tree;

public class Trie树_给定一组字符串_找到能代表每个字符串的最小前缀 {
    public static void main(String[] args) {

    }
    //遍历trie时，第一次是n个查询的字符串。
//
//     for(int i=0;i<n;i++){
//        trie_node* p=root;
//        int j=0;
//        for(;j<strs[i].length();j++){
//            if(p->next[strs[i][j]-'a']->cnt == 1){
//                cout<<strs[i].substr(0,j+1)<<endl;
//                break;
//            }
//            p=p->next[strs[i][j]-'a'];
//        }
//        if(j==strs[i].length()){
//            cout<<strs[i]<<endl;
//        }
//    }
}

package typical.string;

public class FindUniqueSubstring {
    // 从..zabcd...zabc...z...中  找到  p 中substring的个数 ，比如 cab:  c,a,ab,b
    public int findSubstringInWraproundString(String p) {
        // 注意  是 unique;   即  abcdabcd;  其中两个以d结尾，只算一个；
        int[] count = new int[26];
        int res = 0;
        int maxLen = 0;
        for(int i=0;i<p.length();i++){
            if(i==0||p.charAt(i)-p.charAt(i-1)==1||p.charAt(i-1)-p.charAt(i)==25){
                maxLen++;
            }else{
                maxLen = 1;
            }
            int idx = p.charAt(i)-'a';
            count[idx]=Math.max(count[idx],maxLen);
        }
        for(int a:count){
            res+=a;
        }
        return res;
    }
}

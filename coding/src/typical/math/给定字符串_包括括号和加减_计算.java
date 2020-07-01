package typical.math;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 给定字符串_包括括号和加减_计算 {
    // 计算+ - (  )
    public int calculate(String s) {
        char[] sc = s.toCharArray();
        int res = 0;
        Stack<Integer> st = new Stack<>();
        int factor=0;
        int sign = 1;
        int temp = 0;
        for(char c:sc){
            if(Character.isDigit(c)){
                temp = temp*10 + (int)(c-'0');
            }else if(c=='+'){
                res +=temp*sign;
                temp = 0;
                sign = 1;
            }else if(c=='-'){
                res +=temp*sign;
                temp = 0;
                sign = -1;
            }else if(c=='('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }else if(c==')'){
                res +=temp*sign;
                temp = 0;
                int sss = st.pop();
                int rs = st.pop();
                res = sss*res+rs;
            }

        }
        if(temp!=0) res +=temp*sign;
        return res;
    }

    // 计算+ - * /
    public int calculate2(String s) {
        char[] sc = s.toCharArray();
        Stack<Integer> st = new Stack<>();
        int temp = 0;
        int factor = 0;
        char sign = '+';
        for(int i=0;i<sc.length;i++){  // 去除所有* / 只剩下+ -
            char c= sc[i];
            if(Character.isDigit(c)){
                temp = temp*10 +(int)(c-'0');
            }
            if(!Character.isDigit(c)&&c!=' '||i==sc.length-1){ // 当前c是符号，判断前一个符号sign，
                if(sign=='+'){
                    st.push(temp);
                }
                if(sign=='-'){
                    st.push(-temp);
                }
                if(sign=='*'){
                    st.push(st.pop()*temp);
                }
                if(sign=='/'){
                    st.push(st.pop()/temp);
                }
                sign = c;
                temp = 0;
            }
        }
        int res = 0;
        while(!st.isEmpty()){
            res +=st.pop();
        }
        return res;
    }


}

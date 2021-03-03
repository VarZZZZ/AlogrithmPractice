package typical.array_程序代码指南;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/9/9 17:35
 * @Version 1.0
 */
public class 移动数组元素_0转换为其00 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while((str=sc.nextLine())!=null){
            System.out.println(change(str));
        }
    }
    private static String change(String str) {
        char[] sc = str.toCharArray();
        int zeroCnt = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '0') {
                zeroCnt++;
            }
        }
        int idx = sc.length - 1;
        for (int i = sc.length - 1; i >= 0; i--) {
            if (i + zeroCnt >= sc.length) {
                if (sc[i] == '0') {
                    zeroCnt--;
                }
                continue;
            }else{
                sc[idx]=sc[i];
                idx--;
                if(sc[i]=='0'){
                    sc[idx]='0';
                    idx--;
                }
            }
        }
        return new String(sc);
    }

}

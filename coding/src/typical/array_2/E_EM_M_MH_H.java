package typical.array_2;

import java.util.Scanner;

/**
 * @Author: ly
 * @Date: 2020/8/8 16:49
 * @Version 1.0
 */
public class E_EM_M_MH_H {
    static class Main2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] arr = new int[5];

            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += arr[i];
            }
            int a = arr[0] + arr[1];
            int m = arr[1] + arr[2] + arr[3];
            int h = arr[3] + arr[4];
            int res = Math.min(h, Math.min(a, m));
            int end_res = Math.min(sum / 3, res);
            System.out.println(end_res);

        }
    }
}

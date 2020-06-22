package typical.array;

public class 两个矩形所组成的面积_不包括重叠 {

    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
        int left = Math.max(A,E);
        int right = Math.max(left,Math.min(C,G));
        int bottom = Math.max(B,F);
        int top = Math.max(bottom,Math.min(D,H));
        return (C-A)*(D-B)+(G-E)*(H-F) - (right-left)*(top-bottom);
    }
}

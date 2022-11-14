import java.util.*;

public class Coding_Quiz_7 {
    public static void main(String[] args) {
        int[][] big = new int[2540160][10];
        int i = 0;
        for (int S = 1; S < 10; S++) {
            for (int Y = 1; Y < 10; Y++) {
                if (S == Y)
                    continue;
                for (int W = 1; W < 10; W++) {
                    if (S == W || Y == W)
                        continue;
                    for (int N = 0; N < 10; N++) {
                        if (S == N || Y == N || W == N)
                            continue;
                        for (int A = 0; A < 10; A++) {
                            if (S == A || Y == A || W == A || N == A)
                                continue;
                            for (int P = 0; P < 10; P++) {
                                if (S == P || Y == P || W == P || N == P || A == P)
                                    continue;
                                for (int O = 0; O < 10; O++) {
                                    if (S == O || Y == O || W == O || N == O || A == O || P == O)
                                        continue;
                                    for (int F = 0; F < 10; F++) {
                                        if (S == F || Y == F || W == F || N == F || A == F || P == F || O == F)
                                            continue;
                                        for (int T = 0; T < 10; T++) {
                                            if (S == T || Y == T || W == T || N == T || A == T || P == T || O == T || F == T)
                                                continue;
                                            for (int U = 0; U < 10; U++) {
                                                if (S == U || Y == U || W == U || N == U || A == U || P == U || O == U || F == U || T == U)
                                                    continue;
                                                    big[i][0] = S; big[i][1] =Y;big[i][2] =W; big[i][3] =N; big[i][4] =A; big[i][5] =P; big[i][6] =O; big[i][7] =F; big[i][8] =T; big[i][9] =U;  
                                                i++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //SYNAP + SOFT = WANTS + YOU
        //S ,Y ,W, N ,A ,P ,O ,F ,T ,U;
        int left, right;
        int sum = 0;
        for (int[] k : big) {
            left = k[0]*10000+ k[1]*1000+  k[3]*100 +k[4]*10 +k[5] + k[0]*1000 +k[6]*100 +k[7]*10 +k[8];
            right = k[2]*10000+ k[4]*1000+ k[3]*100+ k[8]*10+ k[0] +  k[1]*100+ k[6]*10 +k[9];
            if (left == right) {
                sum+=left;
            }

        }
        System.out.println(sum);

    }
    /*
     * int S ,Y ,W, N ,A ,P ,O ,F ,T ,U;
     * // int[] S = {1,2,3,4,5,6,7,8,9};
     * // int[] Y = {1,2,3,4,5,6,7,8,9};
     * // int[] N = {0,1,2,3,4,5,6,7,8,9};
     * // int[] A = {0,1,2,3,4,5,6,7,8,9};
     * // int[] P = {0,1,2,3,4,5,6,7,8,9};
     * // int[] O = {0,1,2,3,4,5,6,7,8,9};
     * // int[] F = {0,1,2,3,4,5,6,7,8,9};
     * // int[] T = {0,1,2,3,4,5,6,7,8,9};
     * // int[] W = {1,2,3,4,5,6,7,8,9};
     * // int[] U = {0,1,2,3,4,5,6,7,8,9};
     * int[] arr = new int[10];
     * Random r = new Random();
     * for (int i = 0; i < 10 ; i++) {
     * if(i < 3){
     * arr[i] = r.nextInt(9) + 1;
     * }else{
     * arr[i] = r.nextInt(10);
     * }
     * }
     * for (int i = 0; i < big.length; i++) {
     * for (int j = 0; j < big.length; j++) {
     * 
     * }
     * }
     */
}

/*
 *  1부터 n까지의 숫자를 하나씩만 써서 만든 n자리 숫자를 팬디지털(pandigital)이라고 부릅니다.
    2143은 4자리 팬디지털인데, 이 수는 동시에 소수이기도 합니다.

    n자리 팬디지털 소수 중에서 가장 큰 수는 무엇입니까?
 */
public class Problem_31 {xxxx
    public static void main(String[] args) {
        int[][] big = new int[2540160][8];
        int max = 6;
        int i = 0;
        for (int S = max; S > 0; S--) {
            for (int Y = max; Y > 0; Y--) {
                if (S == Y)
                    continue;
                for (int W = max; W > 0; W--) {
                    if (S == W || Y == W)
                        continue;
                    for (int N = max; N > 0; N--) {
                        if (S == N || Y == N || W == N)
                            continue;
                        for (int A = max; A > 0; A--) {
                            if (S == A || Y == A || W == A || N == A)
                                continue;
                            for (int P = max; P > 0; P--) {
                                if (S == P || Y == P || W == P || N == P || A == P)
                                    continue;
                               // for (int O = max; O > 0; O--) {
                                  //  if (S == O || Y == O || W == O || N == O || A == O || P == O)
                                    //    continue;
                                   // for (int F = max; F > 0; F--) {
                                        //if (S == F || Y == F || W == F || N == F || A == F || P == F || O == F)
                                        //    continue;
                                        //for (int T = max; T > 0; T--) {
                                            //if (S == T || Y == T || W == T || N == T || A == T || P == T || O == T|| F == T)
                                                //continue;
                                            big[i][0] = S;
                                            big[i][1] = Y;
                                            big[i][2] = W;
                                            big[i][3] = N;
                                            big[i][4] = A;
                                            big[i][5] = P;
                                           // big[i][6] = O;
                                            //big[i][7] = F;
                                            //big[i][8] = T;
                                            i++;

                                        //}
                                   // }
                               // }
                            }
                        }
                    }
                }
            }
        }
        boolean isprime = true;
        int po;
        int sum = 0;
        for (int[] is : big) {
            po = max-1;
            for (int s : is) {
                sum += s * (int) Math.pow(10, po--);
                System.out.println(sum);

            }
            int ss = (int) Math.sqrt(sum);
            for (int j = 2; j <= ss; j++) {
                if (sum % j == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime == true) {
                System.out.println(sum);
                return;
            }
        }
        System.out.println("non");
        return;
    }
}

import java.util.*;;

public class Coding_Quiz_2 {
    // n자릿수 확인
    public static int read4(int n) {

    }

    public static int find(int n) {
        boolean in4 = false;
        int ujul = 0;
        int hangle = 0;
        int mod;
        boolean man = false;
        for (int i = 0; i <= Math.log10(n) / 4; i++) {
            for (int j = 0; j < 4; j++) {
                switch (i) {
                    case 0:
                        if ((mod = n % 10) != 0) {
                            in4 = true;
                            if (j == 0)
                                hangle += 1;
                            else if (mod == 1)
                                hangle += 1;
                            else
                                hangle += 2;
                        }
                    case 1:
                        if ((mod = n % 10) != 0) {
                            in4 = true;
                            if (j == 0) {
                                hangle += 1;
                                if (mod == 1)
                                    man = true;
                            } else if (mod == 1) {
                                hangle += 1;
                                man = false;
                            } else
                                hangle += 2;

                        }
                    default:
                }
                n /= 10;
            }
            if (in4)
                ujul += 1;
        }
        return ujul * hangle;
    }

    public static String toHangle(int n) {
        String[] hangle = {"일","이","삼","사","오","육","칠","팔","구"}
        if (n % 10000 > 0 && n / 10000 > 0) {

        } else if (n % 10000 > 0 && n / 10000 == 0) {
        } else if (n % 10000 == 0 && n / 10000 > 0) {
        } else if (n % 10000 == 0 && n / 10000 == 0) {
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] input = new String[56];
        int[] number = new int[56];
        
        int i = 0;
        int sum = 0;

        for (String string : input) {
            string = sc.next(); // 입력
            number[i] = Integer.parseInt(string.replaceAll("[^0-9]", "")); // , 원 제거
        }
        System.out.println(sum);
    }
}

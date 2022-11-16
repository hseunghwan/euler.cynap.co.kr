
/**
 * n의 약수들 중에서 자신을 제외한 것의 합을 d(n)으로 정의했을 때,
서로 다른 두 정수 a, b에 대하여 d(a) = b 이고 d(b) = a 이면
a, b는 친화쌍이라 하고 a와 b를 각각 친화수(우애수)라고 합니다.

예를 들어 220의 약수는 자신을 제외하면 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110 이므로 그 합은 d(220) = 284 입니다.
또 284의 약수는 자신을 제외하면 1, 2, 4, 71, 142 이므로 d(284) = 220 입니다.
따라서 220과 284는 친화쌍이 됩니다.

10000 이하의 친화수들을 모두 찾아서 그 합을 구하세요.
 */    
public class Problem_21 {
    /*
     * 약수 구하기
     * 1. n의 제곱근 까지 n mod i를 하여 i들을 찾는다.
     * 2. i * x = n 이 되는 x를 찾는다
     * 3. 중복을 제거한다.
     */
    public static int d(int n){
        if(n == 1) return 1;
        int sq = (int) Math.sqrt(n);
        int suma = 1;
        for (int i = 2; i <= sq; i++) {
            if (n % i == 0) {
                suma += i;
                suma += (n / i);
            }
        }
        if (sq * sq == n)
            suma -= sq;
        return suma;
    }
    public static void main(String[] args) {
        int result = 0;
        for(int i = 1; i <= 10000; i++){
            if(i != d(i) && i == (d(d(i)))) {
                result += i;
            }
        }
        System.out.println(result);
    }
}
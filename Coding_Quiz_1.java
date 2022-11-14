import java.util.*;
public class Coding_Quiz_1 {


    /*
     * 자리수 계산
     * 자리 수 만큼 반복문 돌아서 각 자리수 제곱하고 제곱합 계산
     * 
     * 
     */

    public static int find(int k, int[] arr){
        int temp = k;
        if(arr[temp] == 0){
            arr[temp] = -1;
            int next = 0;
            while(temp != 0){
                next += (temp%10) * (temp%10);
                temp/=10;
            }
            return (arr[k] = find(next,arr));
        }else if(arr[temp] == -1){
            return -1;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        int sum = 0;
        int[] table = new int[n+1]; //9999의 자리수 제곱합 최대
        table[1] = 1;
        for(int i = 1; i < n+1 ; i++){
            find(i,table);
        }
        
        for (int i = 0; i < n+1; i++) {
            if(table[i] == 1){
                count++;
                sum += i;
            }
        }
        System.out.println(count + "\n" + sum);
        sc.close();
    }    
}

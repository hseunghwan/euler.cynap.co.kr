/**
 * 몰라 이상해 못풀겟어 450000아닌가?
 */
public class Coding_Quiz_10 {xxx
    public static int howMany(int n){ //n: 지불할 금액
        int result = 0;
        int[] pay = {1,5,10,50,100,500,1000,5000,10000,50000};

        return result;
    }
    public static void main(String[] args) {
        /*
         * 1
         * 1 1 
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         * 
         */
        int[][] arr = new int[10][10];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;
        for(int i = 2; i < 10; i++){
            for(int j = 0; j < i+1; j++){
                if(j == 0){
                    arr[i][j] = 1;
                }else if(i == j){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }
        double sum = 0;
        for (int i = arr.length -1; i >= 0; i--) {
            sum+= arr[9][i] * Math.pow(5, 9-i);
        }
        System.out.print(sum%1000000);

    }
}
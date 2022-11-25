public class Problem_41 {
    public static int getf(int[][] arr, int y, int x) {
        return arr[y][x] / 100;
    }

    public static int getb(int[][] arr, int y, int x) {
        return arr[y][x] % 100;
    }

    public static int find(int[][] arr, int y, int x){
        if(arr[y][x] == 0){
            return 0;
        }
        int f = getf(arr,y,x);
        int b = getb(arr,y,x);
        if(b == find(arr, y+1,x)){

        }else{
            find(arr,y,x+1);
        }
        return f;
    }
    public static void main(String[] args) {
        int[][] aa = new int[6][100];
        int a;
        int j = 0;
        for (int i = 1; (a = (int) Math.log10(i * (i + 1) / 2)) < 4; i++) {
            if (a < 3)
                continue;
            aa[0][j++] = i * (i + 1) / 2;
        }
        j = 0;
        for (int i = 1; (a = (int) Math.log10(i * i)) < 4; i++) {
            if (a < 3)
                continue;
            aa[1][j++] = i * i;
        }
        j = 0;
        for (int i = 1; (a = (int) Math.log10(i * (3 * i - 1) / 2)) < 4; i++) {
            if (a < 3)
                continue;
            aa[2][j++] = i * (3 * i - 1) / 2;
        }
        j = 0;
        for (int i = 1; (a = (int) Math.log10(i * (2 * i - 1))) < 4; i++) {
            if (a < 3)
                continue;
            aa[3][j++] = i * (2 * i - 1);
        }
        j = 0;
        for (int i = 1; (a = (int) Math.log10(i * (5 * i - 3) / 2)) < 4; i++) {
            if (a < 3)
                continue;
            aa[4][j++] = i * (5 * i - 3) / 2;
        }
        j = 0;
        for (int i = 1; (a = (int) Math.log10(i * (3 * i - 2))) < 4; i++) {
            if (a < 3)
                continue;
            aa[5][j++] = i * (3 * i - 2);
        }


        find(aa,0,0,1);
    }
}

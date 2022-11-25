import java.io.*;
import java.util.*;

//'A' = 65
public class Coding_Quiz_8 {
    public static void setno0(String s, List<Boolean> no0) { // 첫 글자여서 0이 안되는 알파뱃 기록
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^A-Z]", " ");
        String[] temp = s.split(" ");

        for (String str : temp) {
            no0.set(str.charAt(0) - 65, true);
        }
    }

    public static String plains(String s) { // 문자열의 기호, 중복 제거
        s = s.replaceAll("[^A-Z]", "");
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i)
                answer += s.charAt(i);
        }
        return answer;
    }

    public static int valid(List<Integer> alphabet, List<Boolean> no0, int i, String plain, int j) { //
        if (plain.length() <= i)
            return 2;
        else if ((j == 0 && no0.get(plain.charAt(i) - 65)) || alphabet.contains(j))
            return 0;
        else
            return 1;
    }

    public static void possiblenum(List<List<Integer>> all, List<Integer> alphabet, List<Boolean> no0, int i,
            String plain) {
        int is;
        int j = 0;
        for (; j < 10; j++) {
            if ((is = valid(alphabet, no0, i, plain, j)) == 2) {
                all.add(new ArrayList<>(alphabet));
                return;
            } else if (is == -1 || is == 0) {

            } else {
                alphabet.set(plain.charAt(i) - 65, j);
                possiblenum(all, new ArrayList<>(alphabet), no0, i + 1, plain);
            }
        }
    }

    public static int calculate(String s, List<List<Integer>> all) {
        int[] sum = { 0, 0 };
        int lr = 0;
        String buf = "";
        char c;
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if (c >= 'A' && c <= 'Z') { // 문자면
                    buf += all.get(i).get(c - 65);
                } else { // 기호면
                    sum[lr] += Integer.parseInt(buf);
                    buf = "";
                    lr++;
                }
            }
            sum[lr] += Integer.parseInt(buf);
            buf = "";
            if (sum[0] == sum[1] * 3) // *3
                return 1;
            buf = "";
            lr = 0;
            sum[0] = 0;
            sum[1] = 0;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Boolean> no0 = new ArrayList<>(Collections.nCopies(26, false));
        List<Integer> alphabet = new ArrayList<>(Collections.nCopies(26, -1));
        List<List<Integer>> all = new ArrayList<>();
        String s, plain;
        int count = 0;

        for (;;) {
            s = bf.readLine();
            s += "= COFFEE";
            if ((plain = plains(s)).length() > 10)
                continue; // 알파뱃수가 10초과 인지 확인
            setno0(s, no0);
            possiblenum(all, alphabet, no0, 0, plain);
            if (calculate(s.replaceAll(" ", ""), all) != 0)
                count++;
            if (count == 78) {
                System.out.println(s);
                return;
            }

            no0.replaceAll(o -> false);
            alphabet.replaceAll(o -> -1);
            all.clear();
        }
    }
}

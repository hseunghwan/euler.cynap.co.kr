import java.io.*;
import java.util.*;

//'A' = 65
public class Coding_Quiz_9 {
    public static void setno0(String s, List<Boolean> no0) { //첫 글자여서 0이 안되는 알파뱃 기록
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^A-Z]", " ");
        String[] temp = s.split(" ");

        for (String str : temp) {
            no0.set(str.charAt(0) - 65, true);
        }
    }

    public static String plains(String s) { //문자열의 기호, 중복 제거
        s = s.replaceAll("[^A-Z]", "");
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i)
                answer += s.charAt(i);
        }
        return answer;
    }

    public static int valid(List<Integer> alphabet, List<Boolean> no0, int i, String plain, int j) { //j를 입력할 수 있는지 확인
        if (plain.length() <= i)// 모든 조합을 찾으면
            return 2;
        else if ((j == 0 && no0.get(plain.charAt(i) - 65)) || alphabet.contains(j)) //0이 못들어가거나 중복이 있는경우
            return 0;       
        else
            return 1; //대입이 가능한 경우
    }
    //백트랙킹 알고리즘
    //가능한 알파뱃 숫자 조합 list를 저장하는 2차원 list all
    public static void possiblenum(List<List<Integer>> all, List<Integer> alphabet, List<Boolean> no0, int i, String plain) {
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
        int lr = 0, result = 0;
        String buf = "";
        char c;
        char temp = ' ';
        for (int i = 0; i < all.size(); i++) {
            for (int j = 0; j < s.length(); j++) {
                c = s.charAt(j);
                if (c >= 'A' && c <= 'Z') { //문자면
                    buf += all.get(i).get(c - 65);
                } else { //기호면
                    if (c == '=') {
                        if (temp == '+') {
                            sum[lr] += Integer.parseInt(buf);
                            buf = "";
                        } else if (temp == '*') {
                            sum[lr] *= Integer.parseInt(buf);
                            buf = "";
                        } else if (temp == ' ') {
                            sum[lr] += Integer.parseInt(buf);
                            buf = "";
                        }
                        lr++;
                        temp = ' ';
                    } else if (temp == ' ') {
                        sum[lr] += Integer.parseInt(buf);
                        buf = "";
                        temp = c;
                    } else {
                        if (temp == '+') {
                            sum[lr] += Integer.parseInt(buf);
                            buf = "";
                        } else if (temp == '*') {
                            sum[lr] *= Integer.parseInt(buf);
                            buf = "";
                        }
                    }
                }
            }
            if (temp == ' ' || temp == '+') {
                sum[lr] += Integer.parseInt(buf);
                buf = "";
            } else if (temp == '*') {
                sum[lr] *= Integer.parseInt(buf);
                buf = "";
            }
            if (sum[0] == sum[1])
                result += sum[0];
            buf = "";
            lr = 0;
            temp = ' ';
            sum[0] = 0;
            sum[1] = 0;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Boolean> no0 = new ArrayList<>(Collections.nCopies(26, false));
        List<Integer> alphabet = new ArrayList<>(Collections.nCopies(26, -1));
        List<List<Integer>> all = new ArrayList<>();
        String s, plain;
        int result = 0;

        for (int i = 0; i < 21; i++) {
            s = bf.readLine();
            if ((plain = plains(s)).length() > 10)
                continue;                                       // 알파뱃수가 10초과 인지 확인
            setno0(s, no0);                                     // 0이 못들어가는 자리 저장
            possiblenum(all, alphabet, no0, 0, plain);        // 가능한 모든 조합 구하기
            result += calculate(s.replaceAll(" ", ""), all); //좌변 우변이 같은 경우 구하기

            no0.replaceAll(o -> false);
            alphabet.replaceAll(o -> -1);
            all.clear();
        }
        System.out.println(result);
    }
}

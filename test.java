import java.lang.reflect.Array;
import java.util.*;
import java.io.*;
/**
 * test
 */
public class test {
    public static void setno0(String s) {
        s = s.replaceAll(" ", "");
        s = s.replaceAll("[^A-Z]", " ");
        System.out.println(s);

        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> alphabet = new ArrayList<>(Collections.nCopies(26, 2));

        System.out.println(alphabet);

        alphabet.replaceAll(s -> -1);

        System.out.println(alphabet);
    
    }
}
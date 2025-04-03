import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<String> arr = new ArrayList<>();
    static String preStr;
    static StringBuilder answerSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            arr.add(br.readLine());
        }

        arr.sort(new MyComparator());

        for(String str : arr) {
            if(!str.equals(preStr)) {
                answerSb.append(str).append('\n');
            }
            preStr = str;
        }

        System.out.print(answerSb);
    }

    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        }
    }
}
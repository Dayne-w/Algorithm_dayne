import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<String> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            arr.add(br.readLine());
        }

        arr.sort(new IComparator());

        for(String str : arr) {
            sb.append(str).append('\n');
        }

        System.out.print(sb);
    }

    public static class IComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if(o1.length() == o2.length()) {
                int total1 = 0;
                int total2 = 0;
                for(int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9') total1 += o1.charAt(i) - '0';
                }
                for(int i = 0; i < o2.length(); i++) {
                    if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9') total2 += o2.charAt(i) - '0';
                }
                if(total1 == total2) {
                    int idx = 0;
                    while(idx <= o1.length()) {
                        if(o1.charAt(idx) != o2.charAt(idx)) {
                            return (o1.charAt(idx) - '0') - (o2.charAt(idx) - '0');
                        }
                        idx++;
                    }
                    return (o1.charAt(0) - '0') - (o2.charAt(0) - '0');
                }
                return total1 - total2; // ?
            }
            return o1.length() - o2.length();
        }
    }
}
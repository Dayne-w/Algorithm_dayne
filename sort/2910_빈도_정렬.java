import java.io.*;
import java.util.*;

public class Main {

    static int N, C;
    static ArrayList<Integer> arr = new ArrayList<>();
    static ArrayList<Integer> origin = new ArrayList<>();
    static Map<Integer, Integer> m = new HashMap<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr.add(n);
            origin.add(n);
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        arr.sort(new MyComparator());

        for(int n : arr) {
            answerSB.append(n).append(" ");
        }

        System.out.print(answerSB);

    }

    public static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer n1, Integer n2) {
            if(m.get(n1) == m.get(n2)) {
                return origin.indexOf(n1) - origin.indexOf(n2);
            }
            return m.get(n2) - m.get(n1);
        }
    }
}
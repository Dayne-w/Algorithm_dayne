import java.io.*;
import java.util.*;

public class Main {

    static int K, L;
    static Map<String, Integer> m = new HashMap<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int idx = 0;
        for(int i = 0; i < L; i++) {
            String studentNum = br.readLine();
            m.put(studentNum, ++idx);
        }

        ArrayList<Pair> arr = new ArrayList<>();

        for(Map.Entry<String, Integer> e : m.entrySet()) {
            arr.add(new Pair(e.getKey(), e.getValue()));
        }

        arr.sort((o1, o2) -> {
            return o1.idx - o2.idx;
        });

        ListIterator<Pair> listIter = arr.listIterator();

        if(K < m.size()) {
            while(listIter.nextIndex() < K) {
                answerSB.append(listIter.next().studentNum).append('\n');
            }
        }else {
            while(listIter.hasNext()) {
                answerSB.append(listIter.next().studentNum).append('\n');
            }
        }


        System.out.print(answerSB);

    }

    public static class Pair {
        public String studentNum;
        public int idx;

        public Pair(String studentNum, int idx) {
            this.studentNum = studentNum;
            this.idx = idx;
        }
    }
}
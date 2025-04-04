import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        arr.sort(Comparator.reverseOrder());

        ListIterator<Integer> listIter = arr.listIterator();
        while(listIter.hasNext()) {
            int n = listIter.next();
            int nIdx = listIter.nextIndex();
            System.out.println(n + " " + nIdx);
            answer = Math.max(answer, n * nIdx);
        }

        System.out.print(answer);

    }
}
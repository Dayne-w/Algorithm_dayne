import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static ArrayList<Integer> A = new ArrayList<>();
    static ArrayList<Integer> B = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());

        ListIterator<Integer> AListIter = A.listIterator();
        ListIterator<Integer> BListIter = B.listIterator();

        for(int i = 0; i < N; i++) {
            answer += AListIter.next() * BListIter.next();
        }

        System.out.print(answer);
    }
}
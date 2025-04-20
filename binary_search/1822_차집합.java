import java.util.*;
import java.io.*;

public class Main {

    static int nA;
    static int nB;
    static ArrayList<Integer> aArrayList = new ArrayList<>();
    static ArrayList<Integer> bArrayList = new ArrayList<>();
    static ArrayList<Integer> answerArrayList = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nA = Integer.parseInt(st.nextToken());
        nB = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nA; i++) {
            aArrayList.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nB; i++) {
            bArrayList.add(Integer.parseInt(st.nextToken()));
        }

        bArrayList.sort(Comparator.naturalOrder());

        for(int n : aArrayList) {
            if(Collections.binarySearch(bArrayList, n) < 0) {
                answerArrayList.add(n);
            }
        }

        if(answerArrayList.isEmpty()) {
            answerSB.append(0);
        }else {
            answerArrayList.sort(Comparator.naturalOrder());
            answerSB.append(answerArrayList.size()).append('\n');
            for(int n : answerArrayList) {
                answerSB.append(n).append(" ");
            }
        }

        System.out.print(answerSB.toString());
    }
}
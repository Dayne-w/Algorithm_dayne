import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static ArrayList<Integer> numArr = new ArrayList<>();
    static ArrayList<Integer> backTrackingArr = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numArr.add(Integer.parseInt(st.nextToken()));
        }

        numArr.sort(Comparator.naturalOrder());

        back_tracking(0);

        System.out.print(answerSB.toString());
    }

    public static void back_tracking(int start) {
        if(backTrackingArr.size() == M) {
            for(int n : backTrackingArr) {
                answerSB.append(n).append(" ");
            }
            answerSB.append('\n');
            return;
        }
        int beforeNum = -1;
        for(int i = start; i < numArr.size(); i++) {
            if(beforeNum == numArr.get(i)) continue;
            beforeNum = numArr.get(i);
            backTrackingArr.add(numArr.get(i));
            back_tracking(i);
            backTrackingArr.remove(backTrackingArr.size()-1);
        }
    }
}
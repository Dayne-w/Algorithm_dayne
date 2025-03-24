import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException{
        long N, S;
        long sum = 0L, answer = 100000L;
        int left = 0, right = 0;
        boolean check = false;
        ArrayList<Long> numArr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        S = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            numArr.add(Long.parseLong(st.nextToken()));
        }

        sum = numArr.get(0);

        while(left < numArr.size() && left <= right) {
            if(sum < S) {
                right++;
                if (right == numArr.size()) break;
                sum += numArr.get(right);
            }else {
                answer = Math.min(answer, right-left+1);
                sum -= numArr.get(left);
                left++;
                check = true;
            }
        }
        if(!check) {
            System.out.print(0);
        }else {
            System.out.print(answer);
        }
    }
}
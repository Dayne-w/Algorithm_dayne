import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) > Math.abs(o2)) {
                    return Math.abs(o1) - Math.abs(o2);
            }else if (Math.abs(o1) == Math.abs(o2)) {
                return o1 - o2;
            }else {
                return -1;
            }
        });
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.isEmpty()) {
                    sb.append("0").append('\n');
                }else {
                    sb.append(pq.remove()).append('\n');
                }
            }else {
                pq.add(num);
            }
        }

        System.out.print(sb);
    }
}
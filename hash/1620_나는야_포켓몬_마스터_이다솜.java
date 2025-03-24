import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N, M;
        Map<Integer, String> intToStringMap = new HashMap<>();
        Map<String, Integer> stringToIntMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            intToStringMap.put(i, name);
            stringToIntMap.put(name, i);
        }

        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(input.charAt(0) - '0' >= 0 && input.charAt(0) - '0' < 10) {
                sb.append(intToStringMap.get(Integer.parseInt(input))).append("\n");
            }else {
                sb.append(stringToIntMap.get(input)).append("\n");
            }
        }

        System.out.print(sb);
    }
}
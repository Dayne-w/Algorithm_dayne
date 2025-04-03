import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= N; i++) {
            arr[i] = arr[i-1] % 10007 + arr[i-2] % 10007;
        }

        System.out.print(arr[N] % 10007);
    }
}
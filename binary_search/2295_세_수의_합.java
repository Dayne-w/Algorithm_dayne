import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Set<Integer> sumSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N-1; i++) {
            for(int j = i; j < N; j++) {
                sumSet.add(arr[i] + arr[j]);
            }
        }

        boolean check = false;
        for(int i = N-1; i >= 0; i--) {
            if(check) break;
            for (int n : sumSet) {
                if (Arrays.binarySearch(arr, arr[i] - n) >= 0) {
                    System.out.println(arr[i]);
                    check = true;
                    break;
                }
            }
        }
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr = new int[1000001];
    static int[] beforeNum = new int[1000001];
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr[1] = 0;
        beforeNum[1] = 0;

        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i-1] + 1;
            beforeNum[i] = i-1;
            if(i % 3 == 0) {
                if(arr[i] > arr[i/3] + 1) {
                    arr[i] = arr[i/3] + 1;
                    beforeNum[i] = i/3;
                }
            }
            if(i % 2 == 0) {
                if(arr[i] > arr[i/2] + 1) {
                    arr[i] = arr[i/2] + 1;
                    beforeNum[i] = i/2;
                }
            }
        }

        answerSB.append(arr[N]).append('\n');

        while(N != 0) {
            answerSB.append(N).append(" ");
            N = beforeNum[N];
        }

        System.out.print(answerSB.toString());
    }
}
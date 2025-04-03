import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int answer = 0;
    static int[] arr = new int[1000001];
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // arr 채우기
        arr[1] = 1;
        for(int i = 2; i <= N; i++) {
            if(i % 3 == 0 && i % 2 == 0) {
                arr[i] = Math.min(arr[i/3], arr[i/2]) + 1;
            }else if(i % 3 == 0) {
                arr[i] = Math.min(arr[i/3], arr[i-1]) + 1;
            }else if(i % 2 == 0) {
                arr[i] = Math.min(arr[i/2], arr[i-1]) + 1;
            }else {
                arr[i] = arr[i-1] + 1;
            }
        }

        while(N != 0) {
            answerSB.append(N).append(" ");
            if(N % 3 == 0 && N % 2 == 0) {
                if(arr[N/3] < arr[N/2]) {
                    if(arr[N-1] < arr[N/3]) {
                        N -= 1;
                    }else {
                        N /= 3;
                    }
                }else {
                    if(arr[N-1] < arr[N/2]) {
                        N -= 1;
                    }else {
                        N /= 2;
                    }
                }
            }else if(N % 3 == 0) {
                if(arr[N-1] < arr[N/3]) {
                    N -= 1;
                }else {
                    N /= 3;
                }
            }else if(N % 2 == 0) {
                if(arr[N-1] < arr[N/2]) {
                    N -= 1;
                }else {
                    N /= 2;
                }
            }else {
                N -= 1;
            }
            answer++;
        }
        System.out.println(answer-1);
        System.out.print(answerSB);
    }
}
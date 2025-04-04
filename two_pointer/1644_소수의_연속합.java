import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static boolean[] checkPrimeArr = new boolean[4000001];
    static int[] primeArr = new int[4000001];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 2; i*i <= N; i++) {
            if(!checkPrimeArr[i]) {
                for(int j = i; i*j <= N; j++) {
                    checkPrimeArr[i*j] = true;
                }
            }
        }

        int idx = 0;
        for(int i = 2; i <= N; i++) {
            if(!checkPrimeArr[i]) primeArr[idx++] = i;
        }

        if(N == 1) {
            System.out.print(0);
        }else{
            int left = 0, right = 0, sum = 2;
            while(left < idx && left <= right) {
                if(sum < N) {
                    if(right+1 == idx) break;
                    sum += primeArr[++right];
                }
                if(sum == N) {
                    answer++;
                    sum -= primeArr[left++];
                }
                if(sum > N) {
                    sum -= primeArr[left++];
                }
            }
            System.out.print(answer);
        }
    }
}
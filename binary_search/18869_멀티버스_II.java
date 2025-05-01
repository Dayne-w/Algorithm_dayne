import java.util.*;
import java.io.*;

public class Main {

    static int M;
    static int N;
    static ArrayList<Integer>[] planets = new ArrayList[101];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 101; i++) {
            planets[i] = new ArrayList<>();
        }

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int size = Integer.parseInt(st.nextToken());
                planets[i].add(size);
            }

            planets[i] = compress(planets[i]);
        }

        for(int i = 0; i < M-1; i++) {
            for(int j = i+1; j < M; j++) {
                boolean check = false;
                for (int k = 0; k < N; k++) {
                    int n1 = planets[i].get(k);
                    int n2 = planets[j].get(k);
                    if (n1 != n2) {
                        check = true;
                        break;
                    }
                }
                if(!check) answer++;
            }
        }

        System.out.print(answer);
    }

    public static ArrayList<Integer> compress(ArrayList<Integer> arr) {
        ArrayList<Integer> returnArr = new ArrayList<>();

        TreeSet<Integer> s = new TreeSet<>(arr);
        ArrayList<Integer> tempArr = new ArrayList<>(s);
        // 좌표 압축
        for(int i = 0; i < N; i++) {
             returnArr.add(lowerBound(tempArr, arr.get(i)));
        }
        return returnArr;
    }

    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size();
        int mid;
        while(low < high) {
            mid = (low + high) / 2;
            if(target > arr.get(mid)) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
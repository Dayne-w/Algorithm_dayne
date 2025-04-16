import java.util.*;
import java.io.*;

public class Main {

    static int T;
    static int A, B;
    static ArrayList<Integer> aArr;
    static ArrayList<Integer> bArr;
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int sum = 0;
            // A와 B에 입력값 넣기
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            aArr = new ArrayList<>();
            bArr = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A; i++) {
                aArr.add(Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < B; i++) {
                bArr.add(Integer.parseInt(st.nextToken()));
            }

            // A는 내림차순 정렬, B는 오름차순 정렬
            aArr.sort(Comparator.reverseOrder());
            bArr.sort(Comparator.naturalOrder());

            // 개수 구하기
            for(int i = 0; i < A; i++) {
                if(aArr.get(i) <= bArr.get(0)) continue;    // A의 값이 B의 최솟값보다 작으면 건너뛰기
                sum += binarySearch(aArr.get(i));
            }

            answerSB.append(sum).append('\n');
        }

        System.out.print(answerSB);
    }

    // lower Bound
    public static int binarySearch(int target) {
        int high = bArr.size();
        int low = 0;
        while(low < high) {
            int mid = (low + high) / 2;
            if(target > bArr.get(mid)) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}
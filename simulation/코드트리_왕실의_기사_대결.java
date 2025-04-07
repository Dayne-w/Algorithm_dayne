import java.util.*;
import java.io.*;

public class Main {
    static int L, N, Q;
    static int[][] board = new int[41][41]; // 벽과 함정을 표시하는 배열
    static HashMap<Integer, Knight> knightMap = new HashMap<>(); // 기사들의 정보를 관리할 Map (key : 기사 번호, value : 기사 정보)
    static int i, d; // 명령을 저장할 변수
    static BufferedReader br;
    static StringTokenizer st;
    static ArrayList<Knight> pushedKnight = new ArrayList<>();
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        input_first();

        // 명령어 입력
        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            pushedKnight.clear();

            if(!knightMap.containsKey(i)) continue; // 명령 받은 기사가 삭제된 경우

            Knight knight = knightMap.get(i);

            // 기사 이동 & 밀쳐진 다른 기사들도 이동 & 만약 벽 때문에 못 움직이면 continue;

            // checkMove가 true인 경우, 실제로 움직이기
            // checkMove가 false인 경우, continue;
            if(checkMove(knight, d)) {
                move(knight, d);
            }else {
                continue;
            }

            // 밀쳐진 기사들에 대해 대미지 계산 & k<0이면 삭제
            getDamage();
        }

        output();
    }


    public static boolean checkMove(Knight knight, int d) {
        boolean[] visited = new boolean[31]; // 기사의 수만큼 선언
        Queue<Knight> q = new LinkedList();
        q.add(knight);
        visited[knight.num] = true;

        while(!q.isEmpty()) {
            /**
             실제 객체를 조정하면 안됨 => 여기 제대로 동작하나 체크
             */
            Knight knightForCopy = q.remove();
            Knight cur = new Knight(knightForCopy.num, knightForCopy.r, knightForCopy.c, knightForCopy.h, knightForCopy.w, knightForCopy.k);

            if(d == 0) cur.r = cur.r-1;
            if(d == 1) cur.c = cur.c+1;
            if(d == 2) cur.r = cur.r+1;
            if(d == 3) cur.c = cur.c-1;
            if(cur.r < 1 || cur.c < 1 || cur.r+cur.h-1 > L || cur.c+cur.w-1 > L) {
                return false;
            }
            // 벽에 부딪히는 경우도 반영
            for(int i = cur.r; i < cur.r+cur.h; i++) {
                for(int j = cur.c; j < cur.c+cur.w; j++) {
                    if(board[i][j] == 2) {
                        return false;
                    }
                }
            }

            for(Knight k : knightMap.values()) {
                if(k.num == cur.num) {
                    continue; // 자기 자신에 대해서는 check X
                }
                if(checkCollision(cur, k) && !visited[k.num]) {
                    q.add(k);
                    visited[k.num] = true;
                }
            }
        }
        return true;
    }


    // move에서는, 충돌난 기사들을 pushedKnight에 저장까지 해줘야 함
    public static void move(Knight knight, int d) {
        boolean[] visited = new boolean[31]; // 기사의 수만큼 선언
        Queue<Knight> q = new LinkedList();
        q.add(knight);
        visited[knight.num] = true;

        while(!q.isEmpty()) {
            /**
             해당 함수에선 실제 객체를 조정해야 함
             */
            Knight cur = q.remove();
            if(d == 0) cur.r--;
            if(d == 1) cur.c++;
            if(d == 2) cur.r++;
            if(d == 3) cur.c--;
            /**
             이미 checkMove에서 검사 했을 텐데..아래 라인에서 return하는 게 맞나 체크 (return? break? continue?)
             */
            if(cur.r < 1 || cur.c < 1 || cur.r+cur.h-1 > L || cur.c+cur.w-1 > L) return;
            for(Knight k : knightMap.values()) {
                if(k.num == cur.num) continue; // 자기 자신에 대해서는 check X
                if(checkCollision(cur, k) && !visited[k.num]) {
                    q.add(k);
                    pushedKnight.add(k);
                    visited[k.num] = true;
                }
            }
        }
    }


    // 두 기사가 충돌하는지 여부를 반환하는 함수
    public static boolean checkCollision(Knight cur, Knight tmpKnight) {
        // cur의 좌표들을 HashSet에 담고, tmpKnight의 각 좌표에 대해 HashSet에 있는지 여부 판단.
        HashSet<Pair> hashSet = new HashSet<>();

        for(int i = cur.r; i < cur.r + cur.h; i++) {
            for(int j = cur.c; j < cur.c + cur.w; j++) {
                hashSet.add(new Pair(j, i));
            }
        }

        for(int i = tmpKnight.r; i < tmpKnight.r + tmpKnight.h; i++) {
            for(int j = tmpKnight.c; j < tmpKnight.c + tmpKnight.w; j++) {
                for(Pair p : hashSet) {
                    if(p.x == j && p.y == i) return true;
                }
            }
        }

        return false;
    }


    // 이동을 마친 후에, 밀려난 기사들에 대해 대미지를 계산하고, k가 0 이하이면 삭제하는 함수
    public static void getDamage() {
        for(Knight knight : pushedKnight) {
            for(int i = knight.r; i < knight.r + knight.h; i++) {
                for(int j = knight.c; j < knight.c + knight.w; j++) {
                    if(board[i][j] == 1) knight.k--;
                }
            }
            if(knight.k <= 0) knightMap.remove(knight.num);
        }
    }

    // 처음, board와 기사의 정보를 입력 받을 함수
    public static void input_first() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        // board 세팅
        for(int i = 1; i <= L; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= L; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 기사 저장
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            knightMap.put(i, new Knight(i,
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            ));
        }
    }


    // 정답 구하기 (남은 병사들 중에서, 총 받은 대미지의 합)
    public static void output() {
        for(Knight knight : knightMap.values()) {
            answer += (knight.firstK - knight.k);
        }

        System.out.print(answer);
    }


    // 기사들의 정보를 담는 클래스
    public static class Knight {
        public int num;
        public int r;
        public int c;
        public int h;
        public int w;
        public int k;
        public int firstK;

        public Knight(int num, int r, int c, int h, int w, int k) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.h = h;
            this.w = w;
            this.k = k;
            this.firstK = k;
        }
    }

    // 좌표를 나타내는 클래스 checkCollision에서 사용
    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
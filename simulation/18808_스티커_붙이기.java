import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int K;
    static int R, C;
    static boolean[][] laptop;
    static int[][] sticker;
    static int[][] tempSticker;
    static boolean isStickerAttached = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        laptop = new boolean[N][M];

        while(K-- > 0) {
            isStickerAttached = false;
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            sticker = new int[R][C];

            // 스티커 입력
            for(int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 스티커 체크 1이면 원래 모양, 2이면 돌린 모양
            attackSticker(1);

            // 스티커 회전 후 체크 90도
            if(!isStickerAttached) {
                turnSticker(1);
                attackSticker(2);
            }

            // 스티커 회전 후 체크 180도
            if(!isStickerAttached) {
                turnSticker(2);
                attackSticker(1);
            }

            // 스티커 회전 후 체크 270도
            if(!isStickerAttached) {
                turnSticker(1);
                attackSticker(2);
            }
        }
        System.out.print(answer());
    }

    public static void attackSticker(int n) {
        if(n == 1) {
            int y = R;
            while(y <= N) {
                int x = C;
                while(x <= M) {
                    boolean checkLaptop = false;
                    for(int i = y-R; i < y; i++) {
                        for(int j = x-C; j < x; j++) {
                            if(sticker[i-(y-R)][j-(x-C)] == 1 && laptop[i][j]) {
                                checkLaptop = true;
                                break;
                            }
                        }
                        if(checkLaptop) break;
                    }
                    if(!checkLaptop) {
                        isStickerAttached = true;
                        for(int i = y-R; i < y; i++) {
                            for(int j = x-C; j < x; j++) {
                                if(sticker[i-(y-R)][j-(x-C)] == 1) {
                                    laptop[i][j] = true;
                                }
                            }
                        }
                        break;
                    }
                    x++;
                }
                if(isStickerAttached) break;
                y++;
            }
        }

        if(n == 2) {
            int y = C;
            while(y <= N) {
                int x = R;
                while(x <= M) {
                    boolean checkLaptop = false;
                    for(int i = y-C; i < y; i++) {
                        for(int j = x-R; j < x; j++) {
                            if(sticker[i-(y-C)][j-(x-R)] == 1 && laptop[i][j]) {    // 스티커는 그대로의 인덱스는 그대로 0~1까지여야 함
                                checkLaptop = true;
                                break;
                            }
                        }
                        if(checkLaptop) break;
                    }
                    if(!checkLaptop) {
                        isStickerAttached = true;
                        for(int i = y-C; i < y; i++) {
                            for(int j = x-R; j < x; j++) {
                                if(sticker[i-(y-C)][j-(x-R)] == 1) {
                                    laptop[i][j] = true;
                                }
                            }
                        }
                        break;
                    }
                    x++;
                }
                if(isStickerAttached) break;
                y++;
            }
        }
    }

    public static void turnSticker(int n) {
        if(n == 1) {
            tempSticker = new int[C][R];
            for(int i = 0; i < R; i++) {
                for(int j = 0; j < C; j++) {
                    if(sticker[i][j] == 1) {
                        tempSticker[j][R-1-i] = 1;
                    }
                }
            }
            sticker = new int[C][R];
            for(int i = 0; i < C; i++) {
                sticker[i] = Arrays.copyOf(tempSticker[i], tempSticker[i].length);
            }
        }

        if(n == 2) {
            tempSticker = new int[R][C];
            for(int i = 0; i < C; i++) {
                for(int j = 0; j < R; j++) {
                    if(sticker[i][j] == 1) {
                        tempSticker[j][C-1-i] = 1;
                    }
                }
            }
            sticker = new int[R][C];
            for(int i = 0; i < R; i++) {
                sticker[i] = Arrays.copyOf(tempSticker[i], tempSticker[i].length);
            }
        }
    }

    public static int answer() {
        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(laptop[i][j]) answer++;
            }
        }

        return answer;
    }
}
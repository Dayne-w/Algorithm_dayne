import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] board;
    static int[][] tempBoard;
    static int answer = 0;

    // bakcTracking 위한 변수
    static ArrayList<Integer> backArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 입력 받기 및 2048 판 구성
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향 5개 담고, 각각의 방향으로 움직인 결과를 도출 및 최대값 갱신
        backTracking();

        System.out.print(answer);
    }

    public static void backTracking() {
        // 방향이 5개 다 찼을 때
        if(backArr.size() == 5) {
            // 원본 Board를 tempBoard로 복사
            tempBoard = new int[N][N];
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    tempBoard[i][j] = board[i][j];
                }
            }

            // 방향에 따라 이동하는 함수 적용
            for(int i = 0; i < 5; i++) {
                if(backArr.get(i) == 1) {
                    moveUp();
                }
                if(backArr.get(i) == 2) {
                    moveRight();
                }
                if(backArr.get(i) == 3) {
                    moveDown();
                }
                if(backArr.get(i) == 4) {
                    moveLeft();
                }
            }

            // 정답 갱신
            updateAnswer();

            return;
        }

        for(int i = 1; i <= 4; i++) {
            backArr.add(i);
            backTracking();
            backArr.remove(backArr.size()-1);
        }
    }

    // 위로 움직이기
    public static void moveUp() {
        // j는 열, i 는 행
        for(int j = 0; j < N; j++) {
            boolean[] visited = new boolean[N];
            for(int i = 1; i < N; i++) {
                int curRow = i;
                if(tempBoard[curRow][j] == 0) continue;
                if(tempBoard[curRow][j] != 0) {
                    // 되는 곳까지 일단 위로 올리기
                    while(curRow-1 >= 0 && tempBoard[curRow-1][j] == 0) {
                        curRow--;
                    }
                    // 자신 위쪽에 뭐가 없어서, 0행까지 왔을 때
                    if(curRow == 0) {
                        tempBoard[curRow][j] = tempBoard[i][j]; // 원래 자리에서, 위로 옮기기
                        tempBoard[i][j] = 0;    // 원래 자리는 0으로 바꾸기
                        continue;
                    }

                    // 자기 위쪽에 뭐가 있는 경우
                    if(tempBoard[curRow-1][j] == tempBoard[i][j]) {   // 자신과 동일한 숫자인 경우
                        // 아직 합쳐진 행이 아니라면
                        if(!visited[curRow-1]) {
                            tempBoard[curRow-1][j] += tempBoard[i][j];
                            tempBoard[i][j] = 0;
                            visited[curRow-1] = true;
                            continue;
                        }
                    }
                    // 이미 합쳐진 행이라면 || 자신과 다른 숫자인 경우
                    // 만약 안 움직인 경우 (원래 상태가 4 바로 아래 2 이렇게 있는 경우에는 원래 자리를 0으로 만들면 안됨)
                    if(curRow == i) continue;

                    // 만약 움직인 경우
                    tempBoard[curRow][j] = tempBoard[i][j];
                    tempBoard[i][j] = 0;

                }
            }
        }
    }

    // 오른쪽으로 움직이기
    public static void moveRight() {
        for(int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            for(int j = N-2; j >= 0; j--) {
                int curColumn = j;
                // 자기 자신이 0이면 그냥 continue;
                if(tempBoard[i][curColumn] == 0) continue;

                // 자기 자신이 0이 아닐 경우
                if(tempBoard[i][curColumn] != 0) {
                    // 되는 곳까지 일단 오른쪽으로 옮기기
                    while(curColumn+1 < N && tempBoard[i][curColumn+1] == 0) {
                        curColumn++;
                    }
                    // 자신 오른쪽에 뭐가 없어서 N-1열까지 왔을 때
                    if(curColumn == N-1) {
                        tempBoard[i][curColumn] = tempBoard[i][j];
                        tempBoard[i][j] = 0;
                        continue;
                    }

                    // 자기 오른쪽에 뭐가 있는 경우
                    if(tempBoard[i][curColumn+1] == tempBoard[i][j]) {  // 자신과 동일한 숫자인 경우
                        // 아직 합쳐진 행이 아니라면
                        if(!visited[curColumn+1]) {
                            tempBoard[i][curColumn+1] += tempBoard[i][j];
                            tempBoard[i][j] = 0;
                            visited[curColumn+1] = true;
                            continue;
                        }
                    }
                    // 이미 합쳐진 행이라면 ||  자신과 다른 숫자인 경우
                    // 만약 안 움직인 경우 (원래 상태가 4 바로 오른쪽에 2 이렇게 있는 경우에는 원래 자리를 0으로 만들면 안됨)
                    if(curColumn == j) continue;

                        // 만약 움직인 경우
                    tempBoard[i][curColumn] = tempBoard[i][j];
                    tempBoard[i][j] = 0;
                }
            }
        }
    }

    // 아래로 움직이기
    public static void moveDown() {
        // j는 열, i 는 행
        for(int j = 0; j < N; j++) {
            boolean[] visited = new boolean[N];
            for(int i = N-2; i >= 0; i--) {
                int curRow = i;
                if(tempBoard[curRow][j] == 0) continue;
                if(tempBoard[curRow][j] != 0) {
                    // 되는 곳까지 일단 아래로 내리기
                    while(curRow+1 < N && tempBoard[curRow+1][j] == 0) {
                        curRow++;
                    }
                    // 자신 아래쪽에 뭐가 없어서, N-1행까지 왔을 때
                    if(curRow == N-1) {
                        tempBoard[curRow][j] = tempBoard[i][j]; // 원래 자리에서, 아래로 옮기기
                        tempBoard[i][j] = 0;    // 원래 자리는 0으로 바꾸기
                        continue;
                    }

                    // 자기 아래쪽에 뭐가 있는 경우
                    if(tempBoard[curRow+1][j] == tempBoard[i][j]) {   // 자신과 동일한 숫자인 경우
                        // 아직 합쳐진 행이 아니라면
                        if(!visited[curRow+1]) {
                            tempBoard[curRow+1][j] += tempBoard[i][j];
                            tempBoard[i][j] = 0;
                            visited[curRow+1] = true;
                            continue;
                        }
                    }
                    // 이미 합쳐진 행이라면 || 자신과 다른 숫자인 경우
                    // 만약 안 움직인 경우 (원래 상태가 4 바로 위에 2 이렇게 있는 경우에는 원래 자리를 0으로 만들면 안됨)
                    if(curRow == i) continue;

                    // 만약 움직인 경우
                    tempBoard[curRow][j] = tempBoard[i][j];
                    tempBoard[i][j] = 0;
                }
            }
        }
    }

    // 왼쪽으로 움직이기
    public static void moveLeft() {
        for(int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            for(int j = 1; j < N; j++) {
                int curColumn = j;
                // 자기 자신이 0이면 그냥 continue;
                if(tempBoard[i][curColumn] == 0) continue;

                // 자기 자신이 0이 아닐 경우
                if(tempBoard[i][curColumn] != 0) {
                    // 되는 곳까지 일단 왼쪽으로 옮기기
                    while(curColumn-1 >= 0 && tempBoard[i][curColumn-1] == 0) {
                        curColumn--;
                    }
                    // 자신 왼쪽에 뭐가 없어서 0열까지 왔을 때
                    if(curColumn == 0) {
                        tempBoard[i][curColumn] = tempBoard[i][j];
                        tempBoard[i][j] = 0;
                        continue;
                    }

                    // 자기 왼쪽에 뭐가 있는 경우
                    if(tempBoard[i][curColumn-1] == tempBoard[i][j]) {  // 자신과 동일한 숫자인 경우
                        // 아직 합쳐진 행이 아니라면
                        if(!visited[curColumn-1]) {
                            tempBoard[i][curColumn-1] += tempBoard[i][j];
                            tempBoard[i][j] = 0;
                            visited[curColumn-1] = true;
                            continue;
                        }
                    }
                    // 이미 합쳐진 행인 경우 || 자신과 다른 숫자인 경우
                    // 만약 안 움직인 경우 (원래 상태가 4 바로 왼쪽에 2 이렇게 있는 경우에는 원래 자리를 0으로 만들면 안됨)
                    if(curColumn == j) continue;

                    // 만약 움직인 경우
                    tempBoard[i][curColumn] = tempBoard[i][j];
                    tempBoard[i][j] = 0;
                }
            }
        }
    }

    public static void updateAnswer() {
        int maxi = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                maxi = Math.max(maxi, tempBoard[i][j]);
            }
        }
        answer = Math.max(answer, maxi);
    }
}
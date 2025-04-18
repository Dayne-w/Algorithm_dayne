import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Flower> flowers = new ArrayList<>();
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int openMonth = Integer.parseInt(st.nextToken());
            int openDay = Integer.parseInt(st.nextToken());
            int closeMonth = Integer.parseInt(st.nextToken());
            int closeDay = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(openMonth*100 + openDay, closeMonth*100 + closeDay));
        }

        flowers.sort((o1,o2) -> {
           if(o1.start == o2.start) {
               return o2.end - o1.end;
           }
           return o1.start - o2.start;
        });

        int startDay = 301;
        int endDay = 1201;
        int idx = 0, maxDay = 0, answer = 0;

        while(startDay < endDay) {
            check = false;
            for(int i = idx; i < N; i++) {
                if(flowers.get(i).start > startDay) break;

                if(flowers.get(i).end > maxDay) {
                    maxDay = flowers.get(i).end;
                    check = true;
                    idx = i+1;
                }
            }

            if(!check) break;

            answer++;
            startDay = maxDay;
        }

        if(!check) {
            System.out.println(0);
        }else {
            System.out.println(answer);
        }
    }


    // 꽃에 대한 월과 일을 담을 Flower 클래스
    public static class Flower {
        public int start;
        public int end;

        public Flower(int month, int day) {
            this.start = month;
            this.end = day;
        }
    }
}
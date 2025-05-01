import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int P, L, G;
    static int M;
    static TreeMap<Integer, Problem> pNumMap = new TreeMap<>();

    static TreeMap<Integer, TreeSet<Problem>> recommendMap = new TreeMap<>();

    static TreeSet<Problem> recommend2Set = new TreeSet<>((o1, o2) -> {
        if(o1.level == o2.level) {
            return o1.pNum - o2.pNum;
        }
        return o1.level - o2.level;
    });

    static TreeMap<Integer, TreeSet<Problem>> recommend3Map = new TreeMap<>();
    static StringBuilder answerSB = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            Problem p = new Problem(P, L, G);

            pNumMap.put(P, p);

            if(recommendMap.containsKey(G)) {
                TreeSet<Problem> tempSet = recommendMap.get(G);
                tempSet.add(p);
                recommendMap.put(G, tempSet);
            }else {
                TreeSet<Problem> tempSet = new TreeSet<>((o1, o2) -> {
                    if(o1.level == o2.level) {
                        return o1.pNum - o2.pNum;
                    }
                    return o1.level - o2.level;
                });
                tempSet.add(p);
                recommendMap.put(G, tempSet);
            }

            recommend2Set.add(p);

            if(recommend3Map.containsKey(L)) {
                TreeSet<Problem> tempSet = recommend3Map.get(L);
                tempSet.add(p);
                recommend3Map.put(L, tempSet);
            }else {
                TreeSet<Problem> tempSet = new TreeSet<>((o1, o2) -> {
                    return o1.pNum - o2.pNum;
                });
                tempSet.add(p);
                recommend3Map.put(L, tempSet);
            }
        }

        M = Integer.parseInt(br.readLine());

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            if(commend.equals("recommend")) {
                int G = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if(x == 1) {
                    answerSB.append(recommendMap.get(G).last().pNum).append('\n');
                }else {
                    answerSB.append(recommendMap.get(G).first().pNum).append('\n');
                }
            }

            if(commend.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if(x == 1) {
                    answerSB.append(recommend2Set.last().pNum).append('\n');
                }else {
                    answerSB.append(recommend2Set.first().pNum).append('\n');
                }
            }

            if(commend.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int L = Integer.parseInt(st.nextToken());
                Integer key;
                TreeSet<Problem> tempSet;
                if(x == 1) {
                    key = recommend3Map.ceilingKey(L);
                    if(key == null) {
                        answerSB.append("-1").append('\n');
                    }else {
                        tempSet = recommend3Map.get(key);
                        answerSB.append(tempSet.first().pNum).append('\n');
                    }
                }else {
                    key = recommend3Map.lowerKey(L);
                    if(key == null) {
                        answerSB.append("-1").append('\n');
                    }else {
                        tempSet = recommend3Map.get(key);
                        answerSB.append(tempSet.last().pNum).append('\n');
                    }
                }
            }

            if(commend.equals("add")) {
                P = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());
                G = Integer.parseInt(st.nextToken());

                Problem p = new Problem(P, L, G);

                pNumMap.put(P, p);

                if(recommendMap.containsKey(G)) {
                    TreeSet<Problem> tempSet = recommendMap.get(G);
                    tempSet.add(p);
                    recommendMap.put(G, tempSet);
                }else {
                    TreeSet<Problem> tempSet = new TreeSet<>((o1, o2) -> {
                        if(o1.level == o2.level) {
                            return o1.pNum - o2.pNum;
                        }
                        return o1.level - o2.level;
                    });
                    tempSet.add(p);
                    recommendMap.put(G, tempSet);
                }

                recommend2Set.add(p);

                if(recommend3Map.containsKey(L)) {
                    TreeSet<Problem> tempSet = recommend3Map.get(L);
                    tempSet.add(p);
                    recommend3Map.put(L, tempSet);
                }else {
                    TreeSet<Problem> tempSet = new TreeSet<>((o1, o2) -> {
                        return o1.pNum - o2.pNum;
                    });
                    tempSet.add(p);
                    recommend3Map.put(L, tempSet);
                }
            }

            if(commend.equals("solved")) {
                int pNum = Integer.parseInt(st.nextToken());
                Problem p = pNumMap.get(pNum);


                pNumMap.remove(pNum);

                // recommendMap 삭제
                G = p.group;
                TreeSet<Problem> tempSet = recommendMap.get(G);
                tempSet.remove(p);
                if(tempSet.isEmpty()) {
                    recommendMap.remove(G);
                }else {
                    recommendMap.put(G, tempSet);
                }

                // recommend2Set 삭제
                recommend2Set.remove(p);

                // recommend3Map 삭제
                L = p.level;
                tempSet = recommend3Map.get(L);
                tempSet.remove(p);
                if(tempSet.isEmpty()) {
                    recommend3Map.remove(L);
                }else {
                    recommend3Map.put(L, tempSet);
                }
            }
        }

        System.out.print(answerSB.toString());
    }

    public static class Problem {
        public int pNum;
        public int level;
        public int group;

        public Problem(int pNum, int level, int group) {
            this.pNum = pNum;
            this.level = level;
            this.group = group;
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        int T, k;
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++) {
                String[] commands = br.readLine().split(" ");
                int n = Integer.parseInt(commands[1]);
                if(commands[0].equals("I")) {
                    if(treeMap.containsKey(n)) {
                        treeMap.put(n, treeMap.get(n)+1);
                    }else {
                        treeMap.put(n, 1);
                    }
                }else {
                    if(!treeMap.isEmpty()) {
                        if(n == -1) {
                            int firstKeyNum = treeMap.firstKey();
                            if(treeMap.get(firstKeyNum) == 1) {
                                treeMap.remove(firstKeyNum);
                            }else {
                                treeMap.put(firstKeyNum, treeMap.get(firstKeyNum) -1);
                            }
                        }else {
                            int lastKeyNum = treeMap.lastKey();
                            if(treeMap.get(lastKeyNum) == 1) {
                                treeMap.remove(lastKeyNum);
                            }else {
                                treeMap.put(lastKeyNum, treeMap.get(lastKeyNum) -1);
                            }
                        }
                    }
                }
            }

            if(treeMap.isEmpty()) {
                sb.append("EMPTY").append("\n");
            }else {
                sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int n;
        Set<String> workerSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<String> answerArrayList;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String[] tempStrs = br.readLine().split(" ");
            if(tempStrs[1].equals("enter")) {
                workerSet.add(tempStrs[0]);
            }else {
                workerSet.remove(tempStrs[0]);
            }
        }

         answerArrayList = new ArrayList<>(workerSet);

        answerArrayList.sort(Comparator.reverseOrder());

        for(String s : answerArrayList) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);

    }
}
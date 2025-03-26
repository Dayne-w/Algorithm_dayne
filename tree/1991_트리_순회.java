import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Node[] tree = new Node[27];
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cur = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            tree[cur.charAt(0)-'A'] = new Node(cur, left, right);
        }

        preOrder("A");
        sb.append('\n');
        inOrder("A");
        sb.append('\n');
        postOrder("A");

        System.out.print(sb);
    }

    public static void preOrder(String str) {
        sb.append(str);
        char c = str.charAt(0);
        if(!tree[c-'A'].left.equals(".")) preOrder(tree[c-'A'].left);
        if(!tree[c-'A'].right.equals(".")) preOrder(tree[c-'A'].right);
    }

    public static void inOrder(String str) {
        char c = str.charAt(0);
        if(!tree[c-'A'].left.equals(".")) inOrder(tree[c-'A'].left);
        sb.append(str);
        if(!tree[c-'A'].right.equals(".")) inOrder(tree[c-'A'].right);
    }

    public static void postOrder(String str) {
        char c = str.charAt(0);
        if(!tree[c-'A'].left.equals(".")) postOrder(tree[c-'A'].left);
        if(!tree[c-'A'].right.equals(".")) postOrder(tree[c-'A'].right);
        sb.append(str);
    }

    public static class Node {
        public String cur;
        public String left;
        public String right;

        public Node(String cur, String left, String right) {
            this.cur = cur;
            this.left = left;
            this.right = right;
        }
    }
}
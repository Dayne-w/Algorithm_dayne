import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static ArrayList<Student> students = new ArrayList<>();
    static StringBuilder answerSB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            students.add(new Student(name, korean, english, math));
        }

        students.sort((o1, o2) -> {
            if(o1.korean == o2.korean){
                if(o1.english == o2.english) {
                    if(o1.math == o2.math) {
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }

            return o2.korean - o1.korean;
        });

        for(Student s : students) {
            answerSB.append(s.name).append('\n');
        }

        System.out.print(answerSB.toString());
    }

    public static class Student {
        public String name;
        public int korean;
        public int english;
        public int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
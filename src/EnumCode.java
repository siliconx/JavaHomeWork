import java.util.Scanner;

public class EnumCode {
    private static final int N = 5;
    private static final int M = 10;
    enum Grade {
        Excellent, Good, Average, Pass, Fail
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Grade a = Grade.Good;
        int score;
        int grades[] = new int[N];
        for (int i = 0; i < M; ++i) {
            score = in.nextInt();
            ++grades[getGrade(score).ordinal()];
        }

        double rate;
        for (int i = 0; i < N; ++i) {
            rate = grades[i] * 1.0 / M;
            System.out.print(Grade.values()[i] + ": " + rate);
            System.out.println();
        }
    }

    private static Grade getGrade(int score) {
        Grade g = null;
        if (score >= 90) {
            g = Grade.Excellent;
        } else if (score >= 80) {
            g = Grade.Good;
        } else if (score >= 70) {
            g = Grade.Average;
        } else if (score >= 60) {
            g = Grade.Pass;
        } else {
            g = Grade.Fail;
        }
        return g;
    }
}

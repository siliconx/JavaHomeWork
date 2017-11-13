import java.util.HashMap;
import java.util.Scanner;

public class CountingWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] words = str.split(" ");

        // 利用HashMap统计每个单词出现的次数
        HashMap<String, Integer> map = new HashMap<>();
        for (String e : words) {
            if (map.containsKey(e)) {
                map.put(e, map.get(e) + 1);
            } else {
                map.put(e, 1);
            }
        }

        // 找到次数最多的单词， 如果有多个，则找出第一个
        String maxTimesStr = "";
        int max = 0;
        for (String e : words) {
            if (map.get(e) > max) {
                max = map.get(e);
                maxTimesStr = e;
            }
        }

        System.out.println(maxTimesStr + ": " + max);
    }
}

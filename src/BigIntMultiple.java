import java.util.Scanner;
public class BigIntMultiple {
    public static String multi(String str1, String str2) {
        //将接收到的字符串转化成倒序的char数组
        char[] nums1 = new StringBuffer(str1).reverse().toString().toCharArray();
        char[] nums2 = new StringBuffer(str2).reverse().toString().toCharArray();

        //预先声明一个数组，用来存放各个位数相乘的结果(相似于列竖式)
        int len = nums1.length + nums2.length;
        int[] array = new int[len];

        //模拟竖式计算
        for (int i = 0; i < nums2.length; ++i) {
            for (int j = 0; j < nums1.length; ++j) {
                array[len - 1 - (i + j)] += (nums2[i] - 48) * (nums1[j] - 48);
            }
        }

        String result = arrayFormat(array);
        return result;
    }

    public static String pow(String base, int n) {  // 乘方
        String result = base;
        for (int i = 1; i < n; ++i) {
            result = multi(result, base);
        }
        return result;
    }

    public static String plusOne(String n) {  // 加一
        if (n.length() < 1) {
            return null;
        }

        int carry = 0;  // 进位
        int sum = 0;
        int l = n.length();
        StringBuilder s = new StringBuilder(n);

        for (int i = l - 1; i >= 0; --i) {
            sum = s.charAt(i) - '0' + carry;
            if (i == l - 1) {  // 末位加一
                sum += 1;
            }
            carry = sum / 10;
            sum %= 10;
            s.setCharAt(i, (char) (sum + '0'));
        }

        if (carry != 0) {
            s.insert(0, carry);
        }

        return s.toString();
    }

    //对数组进行进位操作。以字符串的形式返回终于结果
    public static String arrayFormat(int[] array){
        for (int i = array.length - 1; i > 0; --i){
            array[i - 1] += array[i] / 10;
            array[i] = array[i] % 10;
        }
        StringBuffer buffer = new StringBuffer();
        if (array[0] != 0){
            buffer.append(array[0]);
        }

        for (int i = 1; i < array.length; ++i){
            buffer.append(array[i]);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(multi("10","10"));
        System.out.println(multi("99","99"));
        System.out.println(pow("2", 100));

        String result = "1";
        for (int i = 1; i <= 100; ++i) {
            result = multi(result, plusOne(pow("2", i)));
        }
        System.out.println(result);
    }
}
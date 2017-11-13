public class TestString {
    public static void main(String[] args) {
        String one = "hello";
        String two = "hello";
        String three = new String("hello");

        System.out.println("1." + (one == two));  // 判断常量one 和 two是否为同一个常量
        System.out.println("2." + one == three);  // 判断 "2." + one 和 three是否为同一个变量
        System.out.println("3." + one.equals(two));  // 判断one 和 two 内容是否相等
        System.out.println("4." + two.compareTo(three));  // 判断字符串 two 和 three 的大小
        System.out.println("5." + one.intern() == three.intern());  // 判断 "5." + 常量池中的 one 和 常量池中的 three 是否相同(扩充常量池方法，首先把three的内容添加到常量池)
    }
}

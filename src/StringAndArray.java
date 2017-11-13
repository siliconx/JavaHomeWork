public class StringAndArray {
    StringBuilder val;
    public static void main(String[] args) {

    }

    private void multiple(StringBuilder str) {

    }

    private void plusOne() {
        if (val.length() < 1) {
            return;
        }

        int carry = 0;
        int temp;
        int index = val.length() - 1;

        temp = (val.charAt(index) - 48) + 1;

        carry = temp / 10;
        temp %= temp;
        val.setCharAt(index, (char) (temp + 48));
        --index;

        while (carry != 0 && index >= 0) {
            --index;
        }

    }
}

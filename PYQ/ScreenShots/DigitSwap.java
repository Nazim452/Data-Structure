public class DigitSwap {

    static void question(int n) {
        String str = String.valueOf(n);

        String ans = str.charAt(str.length() - 1)
                + str.substring(1, str.length() - 1)
                + str.charAt(0);

        System.out.println(Integer.parseInt(ans));

    }

    public static void main(String[] args) {

        int n = 569778;
        question(n);

    }
}

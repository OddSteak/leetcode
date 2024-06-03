public class DRoot {
    // recursive sum of digits of a number
    public static int digital_root(int n) {

        String str;
        int sum = n;

        do {
            str = Integer.toString(sum);
            sum = 0;

            for(int i = 0; i < str.length(); i++) {
                sum +=
                    Character.getNumericValue(str.charAt(i));
            }
        } while(sum >= 10);

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(digital_root(907));
    }
}

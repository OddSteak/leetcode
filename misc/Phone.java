public class Phone {
    public static String createNumber(int[] numbers) {
        String res = String.format("(%d%d%d) %d%d%d-%d%d%d", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4], numbers[5], numbers[6], numbers[7], numbers[8], numbers[9]);

        return res;
    }

    public static void main(String[] args) {
        String res = Phone.createNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}); // => returns "(123) 456-7890"

        System.out.println(res);
    }
}

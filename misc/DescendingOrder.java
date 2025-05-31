import java.util.Arrays;
import java.util.Collections;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        String[] arr = String.valueOf(num).split("");
        Arrays.sort(arr, Collections.reverseOrder());
        return Integer.valueOf(String.join("", arr));
    }

    public static void main(String[] args) {
        System.out.println(sortDesc(145263)); // 654321
    }
}

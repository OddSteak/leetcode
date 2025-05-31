import java.util.ArrayList;

public class SortOdd {
    public static int[] sortArray(int[] array) {
        var oddArr = new ArrayList<Integer>();
        int idx = 0;

        for(int i = 0; i<array.length; i++) {
            if(array[i]%2!=0) oddArr.add(array[i]);
        }

        oddArr.sort((Integer a, Integer b) -> a - b);

        for(int i = 0; i<array.length; i++) {
            if (array[i]%2 != 0) array[i] = oddArr.get(idx++);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = sortArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0});

        for(int i = 0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

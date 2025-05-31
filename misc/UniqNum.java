public class UniqNum {

    /*
     * Kata.findUniq(new double[]{ 1, 1, 1, 2, 1, 1 }); // => 2
        Kata.findUniq(new double[]{ 0, 0, 0.55, 0, 0 }); // => 0.55
        Arrays could be huge so efficiency matters;
     */

    public static double findUniq(double[] arr) {
        double dup = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != dup) {
                if(i+1<arr.length) {
                    if(arr[i+1] == arr[i]) return dup;
                    else return arr[i];
                }
                return arr[i];
            }
        }

        return arr[0];
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 0, 0.55, 0, 0}));
    }
}

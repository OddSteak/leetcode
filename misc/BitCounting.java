public class BitCounting {
    public static int countBits(int n) {
        int res = 0;

        while(n!=0) {
            if(n%2==1) {
                res++;
            }
            n = n/2;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBits(1234));
        System.out.println(countBits(4));
        System.out.println(countBits(7));
        System.out.println(countBits(9));
        System.out.println(countBits(10));
    }
}

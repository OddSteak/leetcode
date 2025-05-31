public class BreakCamel {
    public static String camelCase(String input) {
        // return input.replaceAll("([A-Z])", " $1");
        String res = input;
        int idx = 0;
        for(int i = 0; i<input.length();  i++) {
            char ch = input.charAt(i);

            if(ch >= 65 && ch <= 90) {
                res = res.substring(0, i+idx) + " " +
                    res.substring(i+idx, res.length());
                idx++;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                           camelCase("camelCase"));
    }
}

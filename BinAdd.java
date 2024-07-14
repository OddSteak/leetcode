/*
Input: a = "11", b = "1"
Output: "100"

Input: a = "1010", b = "1011"
Output: "10101"
*/

class BinAdd {
    public String addBinary(String a, String b) {
        String res = "";
        int alen = a.length();
        int blen = b.length();
        char aadd, badd;
        char carry = '0';

        if (alen > blen) {
            b = "0".repeat(alen - blen) + b;
        } else a = "0".repeat(blen - alen) + a;

        for (int i = a.length()-1; i>=0; i--) {
            badd = b.charAt(i);
            aadd = a.charAt(i);

            switch(badd + aadd + carry) {
                case 144: // 0 + 0 + 0
                    res = "0" + res; carry = '0'; break;
                case 145: // 1 + 0 + 0
                    res = "1" + res; carry = '0'; break;
                case 146: // 1 + 1 + 0
                    res = "0" + res; carry = '1'; break;
                case 147: // 1 + 1 + 1
                    res = "1" + res; carry = '1'; break;
            }
        }

        if (carry  == '1') res = "1" + res;
        return res;
    }

    public static void main(String[] args) {
        var ba = new BinAdd();
        System.out.println(ba.addBinary("1010", "1011"));
    }

}

class MorseCode {
    public static String get(String let) {
        return "";
    }
}

public class MorseCodeDecoder {
    public static String decode(String morseCode) {
        // MorseCode.get(code)
        String res = "";
        String let = "";
        int spcCount = 0;
        char ch = ' ';
        int i = 0;

        while(ch == ' ' && i < morseCode.length()) {
            ch = morseCode.charAt(i++);
        }

        while(i < morseCode.length()) {

            if(ch == ' ') {
                spcCount++;
                if(spcCount==1) {
                    res += MorseCode.get(let);
                    let = "";
                }
                if(spcCount == 3) res+=" ";
            } else {
                let += String.valueOf(ch);
                spcCount = 0;
            }
            ch = morseCode.charAt(i++);
        }
        res+=MorseCode.get(let + String.valueOf(ch));

        return res;
    }
}

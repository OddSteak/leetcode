import java.util.Stack;
import java.util.HashMap;

class CheckParen {
    public static boolean isValid(String s) {
        Stack<Character> trc = new Stack<>();
        var hmp = new HashMap<Character, Character>(3, 1);
        hmp.put(')', '(');
        hmp.put('}', '{');
        hmp.put(']', '[');

        for(int i = 0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(hmp.containsValue(ch)) {
                trc.push(ch);
            } else if(hmp.containsKey(ch)) {
                if(trc.isEmpty() || trc.pop() != hmp.get(ch))
                    return false;
            } else return false;
        }

        return trc.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("([)]"));
    }
}

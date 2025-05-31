import java.util.Arrays;
class Anagram {
    public static boolean isAnagram(String s, String t) {
        var l = s.toCharArray();
        var r = t.toCharArray();

        Arrays.sort(l); Arrays.sort(r);
        return Arrays.equals(l, r);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}

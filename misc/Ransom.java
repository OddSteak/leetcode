class Ransom {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        char ch;

        for (int i = 0; i<magazine.length(); i++) {
            ch = magazine.charAt(i);

            count[ch - 'a']++;
        }

        for (int i = 0; i<ransomNote.length(); i++) {
            ch = ransomNote.charAt(i);

            if (count[ch-'a'] == 0) return false;
            count[ch-'a']--;
        }

        return true;
    }
}

class BasedAnagram {
    public boolean isAnagram(String s, String t) {
        int[] ascii = new int[26];

        for(char i: s.toCharArray()){
            ascii[i-'a']++;
        }

        for(char i: t.toCharArray()){
            ascii[i-'a']--;
        }

        for(int i: ascii){
            if(i!=0) return false;
        }

        return true;
    }
}

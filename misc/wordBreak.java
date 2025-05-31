import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return topDownDP(s, new HashSet<>(wordDict));
    }

    public boolean topDownDP(String s, HashSet<String> wordSet) {
        return topDownRec(0, s, wordSet, new HashMap<>());
    }

    public boolean topDownRec(int index, String s, Set<String> wordSet, Map<Integer, Boolean> memo) {
        if (index == s.length()) return true;
        if (memo.containsKey(index)) return memo.get(index);

        for (int i = index + 1; i < s.length() + 1; i++) {
            if (wordSet.contains(s.substring(index, i)) && topDownRec(i, s, wordSet, memo)) {
                memo.put(index, true);
                return true;
            }
        }

        memo.put(index, false);
        return false;
    }

    public boolean bottomUpDP(String s, HashSet<String> wordSet) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j])
                    continue;

                String cur = s.substring(j, i);

                if (wordSet.contains(cur)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public boolean validWord(String word, List<String> wordDict) {
        for (int i = 0; i < wordDict.size(); i++)
            if (word.equals(wordDict.get(i)))
                return true;

        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));

        String s1 = "applepenapple";
        List<String> wordDict1 = new ArrayList<>(Arrays.asList("apple", "pen"));

        String s2 = "catsandog";
        List<String> wordDict2 = new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));

        Solution sol = new Solution();
        assert sol.wordBreak(s, wordDict);
        assert sol.wordBreak(s1, wordDict1);
        assert !sol.wordBreak(s2, wordDict2);
    }
}

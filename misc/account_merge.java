import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        boolean[] visited = new boolean[accounts.size()];

        for (int i = 0; i < accounts.size(); i++) {
            if (visited[i])
                continue;

            res.add(accounts.get(i));
            visited[i] = true;

            for (int j = i + 1; j < accounts.size(); j++) {
                if (res.get(res.size() - 1).get(0).equals(accounts.get(j).get(0))) {
                    boolean same = false;

                    for (int k = 1; k < accounts.get(j).size(); k++) {
                        for (int l = 1; l < res.get(res.size() - 1).size(); l++)
                            if (accounts.get(j).get(k).equals(res.get(res.size() - 1).get(l)))
                                same = true;

                        if (same) {
                            visited[j] = true;
                            for (int m = 1; m < accounts.get(j).size(); m++)
                                res.get(res.size() - 1).add(accounts.get(j).get(m));
                        }
                    }

                }
            }
        }

        return res;
    }
}

import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> hmp = new HashMap<>();
        Queue<Integer> emps = new LinkedList<>();

        for (int i = 0; i < prerequisites.length; i++) {
            if (!hmp.containsKey(prerequisites[i][0])) {
                Set<Integer> set = new HashSet<>();
                set.add(prerequisites[i][1]);
                hmp.put(prerequisites[i][0], set);
            } else {
                hmp.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!hmp.containsKey(i)) {
                hmp.put(i, new HashSet<Integer>());
            }

            if (!hmp.containsKey(i) || hmp.get(i).isEmpty()) {
                emps.add(i);
            }
        }

        while (!emps.isEmpty()) {
            int root = emps.remove();
            hmp.remove(root);
            Set<Integer> set;

            for (Map.Entry<Integer, Set<Integer>> entry : hmp.entrySet()) {
                set = entry.getValue();

                if (set.contains(root)) {
                    set.remove(root);

                    if (set.isEmpty())
                        emps.add(entry.getKey());
                }
            }
        }

        if (!hmp.isEmpty())
            return false;

        return true;
    }
}

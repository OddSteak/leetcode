package heap;
// [https://leetcode.com/problems/task-scheduler/description/]

// Task Scheduler

import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Node {
    int freq;
    int ch;

    public Node(int freq, int ch) {
        this.freq = freq;
        this.ch = ch;
    }
}

class Pair<K, V> {
    K key;
    V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        return optimal(tasks, n);
    }

    // 3 ms - chatgpt
    public int optimal(char[] tasks, int n) {
        int[] freq = new int[26];
        // build frequency list
        for (char task : tasks)
            freq[task - 'A'] += 1;

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 1;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq)
                break;

            maxCount++;
        }

        // maxFreq - 1 is the number of idle slots of size n needed to fit in all the maxFreq tasks
        // multiply by n for the number of idle slots needed
        // multiply by n + 1 for the number of idle slots + a slot for the task
        // all maxfreq tasks can be grouped together so we add maxCount
        // max() because the other tasks might not fit in the window of maxFreq tasks
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }

    // 21 ms - mine
    public int mySolution(char[] tasks, int n) {
        int cycles = 0;
        int[] freq = new int[26];
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq)
                return b.freq - a.freq;
            return b.ch - a.ch;
        });
        Queue<Pair<Integer, Node>> cooling = new LinkedList<>();

        // build frequency list
        for (char task : tasks)
            freq[task - 'A'] += 1;

        // add tasks to priority queue with frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(new Node(freq[i], i));
        }

        while (!pq.isEmpty() || !cooling.isEmpty()) {
            // add cooled down tasks to pq
            if (!cooling.isEmpty() && cooling.peek().getKey() == cycles) {
                pq.offer(cooling.poll().getValue());
            }

            if (!pq.isEmpty()) {
                // perform task
                Node cur = pq.remove();
                cur.freq--;
                // add to cooldown queue if the task is still left
                if (cur.freq > 0) {
                    cooling.offer(new Pair<Integer, Node>(cycles + n + 1, cur));
                }
            } else {
                if (!cooling.isEmpty()) {
                    cycles = cooling.peek().getKey();
                    continue;
                }
            }

            cycles++;
        }

        return cycles;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;

        assert sol.leastInterval(tasks, n) == 8;

        char[] tasks1 = { 'A', 'C', 'A', 'B', 'D', 'B' };
        int n1 = 1;

        assert sol.leastInterval(tasks1, n1) == 6;

        char[] tasks2 = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n2 = 3;

        assert sol.leastInterval(tasks2, n2) == 10;

        char[] tasks3 = { 'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J',
                'J', 'K', 'K', 'L', 'L', 'M', 'M', 'N', 'N', 'O', 'O', 'P', 'P', 'Q', 'Q', 'R', 'R', 'S', 'S', 'T', 'T',
                'U', 'U', 'V', 'V', 'W', 'W', 'X', 'X', 'Y', 'Y', 'Z', 'Z' };
        int n3 = 2;

        assert sol.leastInterval(tasks3, n3) == 52;
    }
}

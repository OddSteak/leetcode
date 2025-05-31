import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(b, a));

        for (int i = 0; i < gifts.length; i++)
            pq.add((long) gifts[i]);

        for (int i = 0; i < k; i++) {
            long cur = pq.remove();
            pq.add((long) Math.sqrt(cur));
        }

        long sum = 0;
        while (!pq.isEmpty())
            sum += pq.remove();

        return sum;
    }
}

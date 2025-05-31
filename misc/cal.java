import java.util.*;

class MyCalendar {
    ArrayList<ArrayList<Integer>> vals;

    public MyCalendar() {
        vals = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        ArrayList<Integer> cur;

        for (int i = 0; i < vals.size(); i++) {
            cur = vals.get(i);

            if (!(end <= cur.get(0) || start >= cur.get(1)))
                return false;
        }

        cur = new ArrayList<>();
        cur.add(start);
        cur.add(end);
        vals.add(cur);

        return true;
    }
}


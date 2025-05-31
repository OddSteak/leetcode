import java.util.*;

class ValTime {
    int time;
    String val;

    public ValTime(int time, String val) {
        this.time = time;
        this.val = val;
    }
}

class TimeMap {
    HashMap<String, ArrayList<ValTime>> hmp = new HashMap<>();

    public TimeMap() {
        hmp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (hmp.containsKey(key)) {
            hmp.get(key).add(new ValTime(timestamp, value));
        } else {
            ArrayList<ValTime> arr = new ArrayList<>();
            arr.add(new ValTime(timestamp, value));
            hmp.put(key, arr);
        }
    }

    public String get(String key, int timestamp) {
        if (!hmp.containsKey(key))
            return "";

        ArrayList<ValTime> arr = hmp.get(key);
        int low = 0;
        int high = arr.size();

        while (low < high) {
            int mid = (high + low) / 2;

            if (arr.get(mid).time > timestamp) {
                high = mid;
                continue;
            }

            if (mid == arr.size() - 1 || arr.get(mid + 1).time > timestamp)
                return arr.get(mid).val;

            low = mid + 1;
        }

        return "";
    }
}

class Solution {
    public static void main(String[] args) {
        TimeMap obj = new TimeMap();
        obj.set("foo", "bar", 1);
        System.out.println(obj.get("foo", 1));
        System.out.println(obj.get("foo", 3));
        obj.set("foo", "bar2", 4);
        System.out.println(obj.get("foo", 4));
        System.out.println(obj.get("foo", 5));
    }
}

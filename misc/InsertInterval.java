class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res;
        int startIdx = -1;
        int endIdx = -1;

        if (intervals.length == 0)
            return new int[][] {newInterval};

        for (int i = 0; i<intervals.length; i++) {
            if (newInterval[0] >= intervals[i][0]) {
                startIdx = i;
            }

            if (newInterval[1] <= intervals[i][1]) {
                endIdx = i;
                break;
            }
        }

        // start before the first interval
        if (startIdx == -1) {
            // overlapping with first
            if (newInterval[1] > intervals[0][0] && endIdx == 0) {
                intervals[0][0] = newInterval[0];
                return intervals;
            }
            // started before first and consumed first, possible spanning multiple intervals

            // completely seperate
            if (newInterval[1] < intervals[endIdx][0]) {
                res = new int[intervals.length - endIdx +1][2];

                res[0] = newInterval;

                for (int i = 0; i<intervals.length; i++) {
                    res[i+1] = intervals[i + endIdx];
                }

                return res;
            }

            // started before first and overlapping with endIdx
            res = new int[intervals.length - endIdx][2];

            res[0] = new int[] {newInterval[0], intervals[endIdx][1]};

            for (int i = 0; i<intervals.length - endIdx - 1; i++) {
                res[i+1] = intervals[i + endIdx + 1];
            }
        }

        if (endIdx == -1) {
            // partially within the last element
            if (newInterval[0] < intervals[intervals.length-1][1]
                    && startIdx == intervals.length-1) {
                intervals[intervals.length-1][1] = newInterval[1];
                return intervals;
            }
            // ends after last element, possible spanning multiple intervals

            res = new int[intervals.length+1][2];

            res[0] = newInterval;

            for (int i = 0; i<intervals.length; i++) {
                res[i+1] = intervals[endIdx];
            }

            return res;
        }


        // within the same interval
        if (startIdx == endIdx)
            return intervals;

        // partially within endIdx
        if (intervals[startIdx][1] < newInterval[0] &&
            intervals[endIdx][0] <= newInterval[1]) {

            res = new int[intervals.length-(startIdx - endIdx-1)][2];
            for (int i = 0; i<=startIdx; i++) {
                res[i] = intervals[i];
            }

            res[startIdx+1] = new int[]
                                {newInterval[0], intervals[endIdx][1]};

            for (int i = endIdx+1; i <= intervals.length; i++) {
                res[startIdx + 1 + i - endIdx] = intervals[i];
            }
            return res;
        }

        // spans accross the two intervals
        if (intervals[startIdx][1] >= newInterval[0] &&
            intervals[endIdx][0] <= newInterval[1]) {
            res = new int[intervals.length - (endIdx - startIdx)][2];

            for (int i = 0; i<startIdx; i++) {
                res[i] = intervals[i];
            }

            res[startIdx] = new int[] {intervals[startIdx][0],
                                    intervals[endIdx][1]};

            for (int i = endIdx+1; i<intervals.length; i++) {
                res[startIdx + i - endIdx] = intervals[i];
            }

            return res;
        }

        // partially within startIdx
        if (newInterval[0] <= intervals[startIdx][1]) {
            res = new int[intervals.length - (endIdx - startIdx - 1)][2];

            for (int i = 0; i<startIdx; i++) {
                res[i] = intervals[i];
            }

            res[startIdx] = new int[] {intervals[startIdx][0],
                                        newInterval[1]};

            for (int i = endIdx; i<intervals.length; i++) {
                res[startIdx + 1 + i - endIdx] = intervals[i];
            }

            return res;
        }

        // on it's own
        res = new int[intervals.length+1][2];

        for (int i = 0; i<=startIdx; i++) {
            res[i] = intervals[i];
        }

        res[startIdx + 1] = newInterval;

        for (int i = endIdx; i < intervals.length; i++) {
            res[startIdx + 1 + i - endIdx] = intervals[i];
        }

        return res;
    }
}

class BadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        return recBase(1, n);
    }

    public int recBase(int start, int end) {
        if (isBadVersion(start)) return start;

        int mid = ++start + ((end-start)/2);

        if (isBadVersion(mid))) {
            return recBase(start, mid);
        } else {
            return recBase(mid+1, end);
        }
    }
}

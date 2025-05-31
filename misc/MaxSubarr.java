class MaxSubarr {
    public int maxSubArray(int[] nums) {
        int high = nums.length;
        int low = 0;
        int total = 0;
        int leftTrim = 0;
        int rightTrim = 0;

        for (int i = low; i<high; i++) {
            if (total + nums[i] <= 0) {
                low = i+1;
                total = 0;  continue;
            }
            total += nums[i];
            if (total > leftTrim) {
                leftTrim = total;
            }
        }

        total = 0;

        for (int i = high-1; i>=low; i--) {
            if (total + nums[i] <= 0) {
                high = i;
                total = 0; continue;
            }
            total += nums[i];
            if (total > rightTrim) rightTrim = total;
        }

        total = 0;

        for (int i = low; i<high; i++) {
            total += nums[i];
        }

        if (low>=high && rightTrim <= 0 && leftTrim <= 0) {
            int highest = nums[0];

            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > highest) highest = nums[i];
            }

            return highest;
        }

        if (total > rightTrim && total > leftTrim) return total;

        return rightTrim > leftTrim ? rightTrim : leftTrim;
    }


    public static void main(String[] args) {
        var mxs = new MaxSubarr();
        System.out.println(
                    mxs.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(
                    mxs.maxSubArray(new int[] {1, 1, -2}));
    }
}

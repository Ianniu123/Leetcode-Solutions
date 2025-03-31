class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)(left * left > x ? left - 1: left);
    }
}
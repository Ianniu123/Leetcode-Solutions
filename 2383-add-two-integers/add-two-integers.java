class Solution {
    public int sum(int num1, int num2) {
        int count = 0;
        if (num1 < 0) {
            for (int i = 0; i < Math.abs(num1); i++) {
                count -= 1;
            }
        } else {
            for (int i = 0; i < num1; i++) {
                count += 1;
            }
        }

        if (num2 < 0) {
            for (int i = 0; i < Math.abs(num2); i++) {
                count -= 1;
            }
        } else {
            for (int i = 0; i < num2; i++) {
                count += 1;
            }
        }

        return count;
    }
}
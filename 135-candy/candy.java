class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];

        for (int i = 0; i < candies.length; i++) {
            candies[i]++;
        }

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = candies.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i - 1], candies[i] + 1);
            }
        }

        int sum = 0;
        for (int num: candies) {
            sum += num;
        }
        return sum;
    }
}
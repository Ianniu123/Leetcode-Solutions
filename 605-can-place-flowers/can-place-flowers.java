class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            boolean ok = flowerbed[i] == 0;
            
            if (i - 1 >= 0) ok = (flowerbed[i - 1] == 0 && ok);
            if (i + 1 < flowerbed.length) ok = (flowerbed[i + 1] == 0 && ok);
            if (ok) {
                count++;
                flowerbed[i] = 1;
            }
        }

        return count >= n;
    }
}
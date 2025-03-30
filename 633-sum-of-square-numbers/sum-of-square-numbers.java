import java.util.HashMap;

class Solution {
    public boolean judgeSquareSum(int c) {
        HashMap<Integer, Integer> ump = new HashMap<>();

        for (int i = 0; i <= Math.sqrt(c); i++) {
            int square = i * i;
            ump.put(square, ump.getOrDefault(square, 0) + 1);
            int req = c - square;

            if (ump.containsKey(req)) {
                return true;
            }
        }

        return false;
    }
}
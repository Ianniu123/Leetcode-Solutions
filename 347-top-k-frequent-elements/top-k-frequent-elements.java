class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int num: nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] lists = new ArrayList[nums.length + 1];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<Integer>();
        }

        for (int num: counts.keySet()) {
            lists[counts.get(num)].add(num);
        }

        int idx = 0;
        int[] ans = new int[k];
        
        for (int i = lists.length - 1; i >= 0; i--) {
            for (int num: lists[i]) {
                ans[idx++] = num;

                if (idx == k) {
                    return ans;
                }
            }
        }

        return new int[0];
    }
}
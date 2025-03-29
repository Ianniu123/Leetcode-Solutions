class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c: t.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;

        String ans = "";
        while (right < s.length()) {
            map1.put(s.charAt(right), map1.getOrDefault(s.charAt(right), 0) + 1);

            //if map equal, then compare with minimum, left = right + 1, right++ and remove the characters along the way
            if (within(map2, map1)) {
                while(!map2.containsKey(s.charAt(left))) {
                    left++;
                }
                
                String temp = s.substring(left, right + 1);
                    
                map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);

                if (map1.get(s.charAt(left)) <= 0) {
                    map1.remove(s.charAt(left));
                }

                left++;

                while(left < s.length() && !map2.containsKey(s.charAt(left))) {
                    left++;
                }

                while (within(map2, map1)) {
                    String st = s.substring(left, right + 1);
                    if (st.length() < ans.length() || ans.length() == 0) {
                        ans = st;
                    }

                    map1.put(s.charAt(left), map1.get(s.charAt(left)) - 1);
                    if (map1.get(s.charAt(left)) <= 0) {
                        map1.remove(s.charAt(left));
                    }
                    left++;
                }
                
                if (temp.length() < ans.length() || ans.length() == 0) {
                    ans = temp;
                }
            }

            right++;
        }

        return ans;
    }

    public boolean within(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        for (char c: source.keySet()) {
            if (!target.containsKey(c) || target.get(c) < source.get(c)) {
                return false;
            }
        }
        return true;
    }
}
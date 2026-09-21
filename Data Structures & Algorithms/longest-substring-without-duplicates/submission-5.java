class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int ptr1 = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int ptr2 = 0; ptr2 < s.length(); ptr2++) {
            char current = s.charAt(ptr2);

            if (map.containsKey(current)) {
                ptr1 = Math.max(ptr1, map.get(current) + 1);
            }

            map.put(current, ptr2);
            ans = Math.max(ans, ptr2 - ptr1 + 1);
        }

        return ans;
    }
}
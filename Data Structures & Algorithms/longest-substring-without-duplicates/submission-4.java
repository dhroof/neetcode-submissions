class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        int ptr1 = 0;
        int ptr2 = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while (ptr2 < s.length()) {
            if (map.get(s.charAt(ptr2)) != null && ptr1 <= map.get(s.charAt(ptr2))) {
                ptr1 = map.get(s.charAt(ptr2)) + 1;
            }

            ans = Math.max(ans, ptr2 - ptr1 + 1);
            map.put(s.charAt(ptr2), ptr2);
            ptr2++;
        }

        return ans;
    }
}

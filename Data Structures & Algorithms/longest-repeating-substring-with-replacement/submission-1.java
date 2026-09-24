class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int ptr1 = 0;
        int maxFreq = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int ptr2 = 0; ptr2 < s.length(); ptr2++) {
            Character c = s.charAt(ptr2);
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);
            maxFreq = Math.max(maxFreq, freq);

            while (ptr2 - ptr1 + 1 - maxFreq > k) {
                map.put(s.charAt(ptr1), map.get(s.charAt(ptr1)) - 1);
                ptr1++;
            }

            ans = Math.max(ans, ptr2 - ptr1 + 1);
        }

        return ans;
    }
}

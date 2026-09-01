class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char i : s.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (char i : t.toCharArray()) {
            int count = map.getOrDefault(i, 0) - 1;
            if (count < 0) return false;
            map.put(i, count);
        }

        return true;
    }
}

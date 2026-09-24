class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];

        for (Character c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int[] freq2 = new int[26];

        int ptr1 = 0;
        for (int ptr2 = 0; ptr2 < s2.length(); ptr2++) {
            if (ptr2 >= s1.length()) {
                freq2[s2.charAt(ptr1) - 'a']--;
                ptr1++;
            }

            freq2[s2.charAt(ptr2) - 'a']++;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}

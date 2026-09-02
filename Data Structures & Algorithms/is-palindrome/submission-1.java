class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        char c1;
        char c2;
        while (i <= j) {
            c1 = Character.toLowerCase(s.charAt(i));
            c2 = Character.toLowerCase(s.charAt(j));

            // Increment left pointer if c1 is not alpha-numeric
            if (!Character.isDigit(c1) && !Character.isLetter(c1)) {
                i++;
                continue;
            }

            // Decrement right pointer if c2 is not alpha-numeric
            if (!Character.isDigit(c2) && !Character.isLetter(c2)) {
                j--;
                continue;
            }

            if (c1 != c2) {
                return false;
            }
            
            i++;
            j--;
        }

        return true;
    }
}

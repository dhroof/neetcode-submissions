class Solution {
    public boolean isPalindrome(String s) {
        String temp = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetter(c)) {
                temp += Character.toLowerCase(c);
            } else if (Character.isDigit(c)) {
                temp += c;
            }
        }

        int i = 0;
        int j = temp.length() - 1;
        while (i <= j) {
            if (temp.charAt(i) != temp.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}

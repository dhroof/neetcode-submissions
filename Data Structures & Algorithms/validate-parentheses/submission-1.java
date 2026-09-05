class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
                continue;
            }

            if (st.isEmpty()) {
                return false;
            }

            char temp = st.pop();
            if ((temp == '(' && c != ')') || (temp == '[' && c != ']')
                || (temp == '{' && c != '}')) {
                return false;
            }
        }

        return st.isEmpty();
    }
}

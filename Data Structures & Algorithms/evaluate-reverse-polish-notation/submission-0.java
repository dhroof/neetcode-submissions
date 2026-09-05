class Solution {
    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        int ptr = 0;
        int num;
        while (ptr < tokens.length) {
            if (!isOperator(tokens[ptr])) {
                num = Integer.parseInt(tokens[ptr]);
                st.push(num);
                ptr++;
                continue;
            }

            int num2 = st.pop();
            int num1 = st.pop();

            if (tokens[ptr].equals("+")) {
                st.push(num1 + num2);
            }

            if (tokens[ptr].equals("-")) {
                st.push(num1 - num2);
            }

            if (tokens[ptr].equals("*")) {
                st.push(num1 * num2);
            }

            if (tokens[ptr].equals("/")) {
                st.push(num1 / num2);
            }

            ptr++;
        }

        return st.pop();
    }
}

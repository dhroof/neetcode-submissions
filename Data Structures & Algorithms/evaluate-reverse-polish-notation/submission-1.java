class Solution {
    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> st.push(st.pop() + st.pop());
                case "-" -> {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    st.push(num1 - num2);
                }
                case "*" -> st.push(st.pop() * st.pop());
                case "/" -> {
                    int num2 = st.pop();
                    int num1 = st.pop();
                    st.push(num1 / num2);
                }
                default -> {
                    st.push(Integer.parseInt(token));
                }
            }
        }

        return st.pop();
    }
}

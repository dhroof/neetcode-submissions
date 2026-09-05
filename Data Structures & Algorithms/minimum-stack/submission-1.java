class MinStack {
    private ArrayList<Integer> stack;
    private ArrayList<Integer> minArr;

    public MinStack() {
        stack = new ArrayList<>();
        minArr = new ArrayList<>();
    }

    public void push(int val) {
        stack.add(val);
        if (minArr.size() == 0 || minArr.get(minArr.size() - 1) >= val) {
            minArr.add(val);
        }
    }

    public void pop() {
        int temp = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        if (minArr.get(minArr.size() - 1) == temp) {
            minArr.remove(minArr.size() - 1);
        }
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }

    public int getMin() {
        return minArr.get(minArr.size() - 1);
    }
}

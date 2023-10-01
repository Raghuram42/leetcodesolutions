class MinStack {
    Stack<int[]> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty())
            stk.push(new int[]{val, val});
        else
            
            stk.push(new int[]{val, Math.min(val, getMin())});
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek()[0];
    }
    
    public int getMin() {
        return stk.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
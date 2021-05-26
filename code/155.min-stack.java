class MinStack {
   Stack<Integer> mins;
    Stack<Integer> org;
    /** initialize your data structure here. */
    public MinStack() {
        mins = new Stack<Integer>();
        org = new Stack<Integer>();
    }
    
    public void push(int x) {
        org.push(x);
        if(mins.isEmpty())
            mins.push(x);
        else {
            if(mins.peek() < x)
            mins.push(mins.peek());
            else
                mins.push(x);
        }
            
    }
    
    public void pop() {
        org.pop();
        mins.pop();
    }
    
    public int top() {
        return org.peek();
    }
    
    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
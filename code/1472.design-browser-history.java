class BrowserHistory {
    Stack<String> stk_C;
    Stack<String> de_f;
    public BrowserHistory(String homepage) {
        
    stk_C = new Stack<String>();
    de_f = new Stack<String>();
        stk_C.push(homepage);
    }
    
    public void visit(String url) {
        if(!de_f.isEmpty())
            de_f = new Stack<String>();
            stk_C.push(url);
    }
    
    public String back(int steps) {
        String curr = stk_C.peek();
        while(steps > 0 && !stk_C.isEmpty()){
            curr = stk_C.pop();
            de_f.push(curr);
            steps--;
        }
        if(stk_C.isEmpty()) stk_C.push(de_f.pop());
        return stk_C.peek();
    }
    
    public String forward(int steps) {
        if(!de_f.isEmpty()){
        String currs= de_f.peek();
        while(steps>0 && !de_f.isEmpty()){
            currs = de_f.pop();
            stk_C.push(currs);
            steps--;
        }
        }
        return stk_C.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
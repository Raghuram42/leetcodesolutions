class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        
   Stack<Integer> stk = new Stack<>();
        stk.push(0);
        int res = 0;
        for(String path: paths){
            int lvl = path.lastIndexOf("\t")+1;
            
            while(lvl+1 < stk.size())
                stk.pop();
            
            int curr = stk.peek()-lvl+1+path.length();
            stk.push(curr);
            if(path.indexOf('.') != -1)
            res = Math.max(res, curr-1);    
            
        }
        
        return res;
    }
}
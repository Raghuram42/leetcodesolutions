class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] mapr = s.toCharArray();
        StringBuilder str = new StringBuilder();
        Deque<Integer> stk = new ArrayDeque<Integer>();
        
        for(int i=0;i<mapr.length;i++){
            if(mapr[i] == '(')
                stk.push(i);
            else if(mapr[i] == ')'){
                if(!stk.isEmpty())
                    stk.pop();
                else mapr[i] = '$';
            }
        }
        
        while(!stk.isEmpty())
            mapr[stk.pop()] = '$';
       for(char c: mapr)
           if(c != '$')
               str.append(c);
        return str.toString();
    }
}
class Solution {
    public String smallestSubsequence(String s) {
        int[] mapr = new int[26];
        int[] hashset = new int[26];
        StringBuilder str = new StringBuilder();
        Stack<Integer> stk = new Stack<Integer>();
        
        
        for(int i=0;i<s.length();i++)
            mapr[s.charAt(i)-'a'] = i;
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            
            if(hashset[ind] == 1)
                continue;
            
            while(!stk.isEmpty() && stk.peek() > ind && i < mapr[stk.peek()])
                hashset[stk.pop()] = 0;
            
            
                stk.push(ind);
                hashset[ind] = 1;
            
        }
        
        while(!stk.isEmpty())
           str.append((char)(stk.pop()+'a')); 
        
        return str.reverse().toString();
        
    }
}
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];
        
        
        for(int i=0;i<n;i++)
            costs[i] = Math.abs(s.charAt(i)-t.charAt(i));
        
        int st = 0;
        int end = 0;
        int sum = 0;
        int window = 0;
        while(end < n){
            sum += costs[end];
            
            while(sum > maxCost)
                sum -= costs[st++];
            window = Math.max(window, end-st+1);
            end++;  
        }
        return window;
    }
}


/*
 "abcd", t = "bcdf", maxCost = 3
     
     
    st = 0, end = 0
     
    1 1 1 2
     */
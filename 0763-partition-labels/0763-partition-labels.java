class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] revIndex = new int[26];
        
        int n = s.length();
        
        int i = 0;
        while(i<n){
            revIndex[s.charAt(i)-'a'] = i;
            i++;
        }
        
        List<Integer> res = new ArrayList<Integer>(); 
        i = 0;
        int last = 0;
        int st = 0;
        while(i<n){
            
            if(last < i)
            {
                res.add(last-st+1);
                st = i;
                last = i;
            }
            last = Math.max(last, revIndex[s.charAt(i)-'a']);
            i++;
        }
        
            if(last < i)
            {
                res.add(last-st+1);
                st = i;
                last = i;
            }
        
        return res;
    }
}
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)
            return 0;
        
        if(needle.length() > haystack.length())
            return -1;
        
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(needle.charAt(0) == haystack.charAt(i))
                q.offer(new int[]{0,i});
        }
        // System.out.println(q);
        // int p = 0;
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz>0){
                int[] currind = q.poll();
                int k = currind[1];
                int ned = currind[0];
      
                if(k<haystack.length() && ned<needle.length() && haystack.charAt(k) == needle.charAt(ned)){
                    k++;
                    ned++;
                    q.offer(new int[]{ned, k});
                }
                    
                
                if(ned == needle.length())
                    return k-ned;
                    
                
                sz--;
            }
        }
        
        return -1;
    }
}
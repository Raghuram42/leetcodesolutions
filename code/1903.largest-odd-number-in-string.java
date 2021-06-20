class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
     
        char[] chary = s.toCharArray();
        
        int l = 0;
        int r = removable.length-1;
        
        
        while(l<=r){
            
            int mid = (l+r)/2;
            
            
            for(int i=0;i<=mid;i++)
                chary[removable[i]] = '/';
            
            
            if(same(chary, p)){
                l = mid+1;
            }
            else{
                
            for(int i=0;i<=mid;i++)
                chary[removable[i]] = s.charAt(removable[i]);
                
                r= mid-1;
            
                
            }
            
        
            
        }
            return l;
        
            
            
    }
    
    public boolean same(char[] ary, String tar){
        
        
        int l= 0;
        int r = 0;
        
        while(l<ary.length && r<tar.length()){
            
            if(ary[l] == tar.charAt(r))
            r++;
            
            l++;
            
        }
        
        return r == tar.length();
        
        
    }
}
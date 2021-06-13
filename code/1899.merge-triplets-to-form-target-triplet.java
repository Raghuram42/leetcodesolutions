class Solution {
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        
        long[] prefix = new long[packages.length];
        for(int i=0;i<packages.length;i++)
            prefix[i] += i==0 ? packages[i] : prefix[i-1]+packages[i];
        
        long waste = Long.MAX_VALUE;
        
        for(int[] box: boxes){
            Arrays.sort(box);
            
            long curres = 0;
            int st = -1;
            for(int i=0;i<box.length;i++){
                
             int ind = bsearch(packages, box[i]);
                // System.out.println(ind +" "+box[i]+" "+st);
             if(ind == -1 || ind >= packages.length)
                 continue;
                
             curres += box[i] *1l* (ind-(st+1)+1)  - (prefix[ind] - (st == -1? 0 : prefix[st]));
                st = ind;
             if(st == packages.length-1){
                 break;
             }
                
            }
            // System.out.println(curres);   
            if(st == packages.length-1)
                waste = Math.min(waste, curres);
            
            
        }
        
        
        return mod(waste==Long.MAX_VALUE?-1:waste);
    }
    public int mod(long val){
        return (int)(val%1000000007);
    }
    
    
    public int bsearch(int[] inp, int target){
        int l=0;
        int r = inp.length-1;
        
        int ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            
            if(inp[mid] <= target){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
                
            
            
        }
        
        return ans;
        
    }
}
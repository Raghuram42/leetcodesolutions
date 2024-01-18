class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> f = new ArrayList<>();
        List<Integer> se = new ArrayList<>();
        
        // for()
        int i = 0;
        
        int n = s.length();
        int m = a.length();
        int o = b.length();
        while(i<=n-m){
            if(s.substring(i, i+m).equals(a))
                f.add(i);
            i++;
        }
        
        i = 0;
        
        while(i<=n-o){
            if(s.substring(i, i+o).equals(b))
                se.add(i);
            i++;
        }
        
        // Collections.sort();
        
        List<Integer> ans = new ArrayList<Integer>();
        
        // System.out.println(se+" "+f);
        i = 0;
        n = f.size();
        while(i < n){
            int t = b(se, f.get(i)+k, i, k);
            if(t  >= 0)
                ans.add(f.get(i));
            i++;
        }
        
        return ans;
        
    }
    
    public int b(List<Integer> s, int tar, int i, int k){
        int l = 0;
        int r = s.size()-1;
        int ans = -1;
        while(l<=r){
            int mid  = (l+r)/2;
            
            if(s.get(mid) <= tar)
            {
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
            
        }
        if(ans == -1)
            return -1;
        
        // System.out.println(i+" "+tar+" "+s.get(ans)+" "+Math.abs(s.get(ans)-(tar-k))+" "+k);
        return Math.abs(s.get(ans)-(tar-k)) <= k ? i : -1;
        
    }
}
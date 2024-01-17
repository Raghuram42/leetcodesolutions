class Solution {
    long[] pr;
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> f = new ArrayList<>();
        List<Integer> se = new ArrayList<>();
        pr = new long[500001];
        // for()
        int i = 0;
        
        int n = s.length();
        int m = a.length();
        int o = b.length();
        
        rabinKarp(s,a, f);
        rabinKarp(s,b, se);
        // Collections.sort();
        
        List<Integer> ans = new ArrayList<Integer>();
        
        // System.out.println(f+" "+se);
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
    
    public void rabinKarp(String s, String t, List<Integer> ans){
        int m = s.length();
        int n = t.length();
        
        int sz = 26;
        int p = Integer.MAX_VALUE;
        long hsh = 0l;
        long hsh1 = 0l;
        int tr = n-1;
        for(int i=0;i<Math.min(n,m);i++){
            long pp = pow(sz*1l ,p,tr);
            
            hsh1 = mod(hsh1+mod(gc(s.charAt(i))*pp));
            hsh = mod(hsh+mod(gc(t.charAt(i))*pp));
            // System.out.println(hsh+" pow "+pp+" "+hsh1);
            tr--;
        }
        // System.out.println(hsh1+" "+hsh);
        if(hsh == hsh1)
            ans.add(0);
        
        tr = n-1;
        int l = 0;
        for(int i=n;i<m;i++){
            long pp = pow(sz*1l ,p,tr);

            hsh1 = mod(mod(hsh1-mod(gc(s.charAt(l))*pp))*sz);
            // System.out.println(hsh+" pow bef "+pp+" "+hsh1+" ind "+i+" "+s.substring(i-n, i));

            hsh1 = mod(hsh1+mod(gc(s.charAt(i))));
            // System.out.println(hsh+" pow out "+pp+" "+hsh1+" ind "+i+" "+" "+gc(s.charAt(l)));
            l++;
            if(hsh1 == hsh ){
                ans.add(i-n+1);
            }
        }
}
    public boolean eq(String t, String s, int st, int end){
        int i = 0;
        while(st <= end){
            if(s.charAt(st) != t.charAt(i))
                return false;
            st++;
            i++;
        }
        return true;
    }
    public long pow(long v, int p, int powr){
        // System.out.println(v+" "+powr);
        if(pr[powr] != 0l)
            return pr[powr];
        
        if(powr == 0)
            return 1;
        if(powr == 1)
            return v;
        
        long v1 = (pow(v, p, powr/2))%p;
        long v2 = (v1*v1)%p;
        if(powr%2 == 0)
            return pr[powr] = v2;
        
        return pr[powr] = (v2*v)%p;
    }
    public int gc(char c){
        return (c-'a')+1;
    }
    public long mod(long n){
        if(n < 0)
            return n+Integer.MAX_VALUE;
        return n%Integer.MAX_VALUE;
    }
}
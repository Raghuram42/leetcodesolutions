class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(nums[0]);
        int i = 1;
        int n = nums.length;
        
        while(i<n){
            int prev = res.get(res.size()-1);
            int next = nums[i];
            int gcd = gcd(prev, next);    
            
            if(gcd > 1 && res.size()>0){
                res.remove(res.size()-1);
                next = lcm(prev, next, gcd);
            }
            
            res.add(next);
            
            check(res);
            i++;
        }
        
        return res;
    }
    public void check(List<Integer> res){
        if(res.size() <= 1)
            return;
        int fir = res.get(res.size()-1);
        int sec = res.get(res.size()-2);
        
        int gcd = gcd(fir, sec);
        
        if(gcd == 1)
            return;
        res.remove(res.size()-1);
        res.remove(res.size()-1);
        
        res.add(lcm(fir, sec, gcd));
        
        check(res);
        return;
    }

    public int gcd(int a, int b){
        if(b == 0)
            return a;
        if(b > a)
            return gcd(a, b%a);
        
        return gcd(b, a%b);
        
    }
    
    public int lcm(int a, int b, int gcd){
        return (int)((a*1l*b)/gcd);
    }
}

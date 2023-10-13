class Solution {
    HashSet<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if(set.contains(n))
            return false;
        set.add(n);
        if(n == 1)
            return true;
        int ans = 0;
        
        while(n > 0){
            ans += (n%10)*(n%10);
            n = n/10;
        }
        
        return isHappy(ans);
    }
}
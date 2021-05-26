class Solution {
    public int minSteps(int n) {
        if(n == 1)
            return 0;
        if((n&(n-1))==0)
            return 2*setbit(n);
        int ans = Integer.MAX_VALUE;
        
        for(int i=n/2;i>=1;i--){
            if(i == 1)
                ans = Math.min(n, ans);
            else
            if(n%i == 0)
                ans = Math.min(ans, i+minSteps(n/i));
        }
        
           return ans;
    }
    public int setbit(int n){
        int ans = -1;
        while(n != 0){
            ans++;
            n = n/2;
        }
        return ans;
    }
}
/*
if n = 1
    A 
    ans - 0
    n=2
    
    ans -  2
    n =3
    ans -3
    n -4
    copy 
    A
    cpy -1 A
    past -1 AA
    copy -1 AA
    paste -1 AAAA
    
    n -5 
    cpy -1 A
    past - 1 AA
    cp
    
    
    n-7 - A
    cpy 1 A
    past 1 AA
    copy 1 AA
    past 1 AAAA
    past 1 AAAAAA
    
    
    32/2 past
    copy
    16/2 past
    copy
    8/2 past
    cpy
    4/2 past
       cpy
    2/2 past
    
    1 -copy
    
    
    34
    
    17
    */
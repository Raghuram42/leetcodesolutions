class Solution {
    public boolean isHappy(int n) {
     HashSet<Integer> hs = new HashSet<Integer>();
     int sum = 0;
        boolean res = true;
        int n1 = n;
        hs.add(n);
        while(true){
            int t = n%10;
            sum += t*t;
            
            n = n/10;
            if(n==0){
          //  System.out.println(sum);    
                if(hs.contains(sum) && sum != 1){
                    res = false;
                    break;
                }
                else if(sum == 1)
                    break;
                    hs.add(sum);
                n = sum;
                sum =0 ;
            }
                
        }
       return res; 
    }
        
}
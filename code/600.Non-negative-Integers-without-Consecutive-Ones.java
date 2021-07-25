class Solution {
    public int findIntegers(int n) {
        if(n == 0)
            return 1;
        if(n==1)
            return 2;
      String binaryString = convertNtoBinary(n);  
      int len = binaryString.length();  
      int[] fib = new int[len];
       fib[0] = 1;
       fib[1] = 2;
        
       for(int i=2;i<len;i++) 
           fib[i] = fib[i-1]+fib[i-2];
        int res = 0;
        for(int i =len-1;i>=0;i--){
            if(binaryString.charAt(i) == '1')
            {
                res += fib[i];
                
                if(i<len-1 && binaryString.charAt(i+1) == '1')
                    return res;
            }
        }
        return res+1;
    }
    public String convertNtoBinary(int n){
        StringBuilder bin = new StringBuilder();
        
        while( n > 0){
            bin.append(n%2);
            n /=2;
        }
        // System.out.println(bin.toString());
        return bin.toString();
    }
}
/*
class Solution {
    public int findIntegers(int n) {
        System.out.println(Integer.toBinaryString(n));
        return 1+subProblem(1, n);
    }
    
    public int subProblem(int num, int end){
        if(num > end)
            return  0;
        
        if((num&1) == 1)
            return 1+subProblem((num<<1)|0, end);
        return 1+subProblem((num<<1)|0, end)+subProblem((num<<1)|1,end);
    }
}
*/

class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1)
            return true;
        if(num%2 != 0 || num < 4)
            return false;
        
        if((num & (num-1)) != 0)
            return false;
        int position = 0; 
        int m = 1; 
        
        while ((num & m) == 0) { 
  
            // left shift 
            m = m << 1; 
            position++; 
        } 
        System.out.println(position);
        return position%2 == 0 ? true : false;
    }
}
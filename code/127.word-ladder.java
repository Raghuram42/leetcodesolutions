class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)
            return true;
    //      System.out.println((char)(48));
        HashSet<Character> hst = new HashSet<Character>();
        
       for(int i=48;i<=57;i++)
           hst.add((char)(i));
        
                
       for(int i=97;i<=122;i++)
           hst.add((char)(i));
        
        s = s.toLowerCase();
                  System.out.println(s);
        int len = s.length();
        int mid = len%2 == 0 ? len/2 : (len/2)+1;
        int l = 0;
        int r = len-1;
        while(l < r){
            Character  f1 = s.charAt(l);
            Character  f2 = s.charAt(r);
            int res = f1.compareTo(f2);
            if(res == 0){
                l++;
                r--;
            }
            else if(!hst.contains(f1) || !hst.contains(f2)){
                if(!hst.contains(f1)){
                    l++;
                }
                if(!hst.contains(f2)){
                r--;    
                }
            }
            else{
                     System.out.println(l + " "+r);
                return false;
            }
            
        }
        

        return true;
    }
}
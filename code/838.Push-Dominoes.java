class Solution {
    public String pushDominoes(String dominoes) {
        HashSet<Integer> set = new HashSet<>();
        int i =0;
        
        int n = dominoes.length();
        
        while( i < n) {
            if(dominoes.charAt(i) != '.')
                set.add(i);
            i++;
        }
        char[] domChar = dominoes.toCharArray();
        while(set.size() > 0){
            
            HashSet<Integer> nextSet = new HashSet<>();
            HashSet<Integer> doneSet = new HashSet<>();
            for(Integer s: set){
                
                if(doneSet.contains(s))
                    continue;
                else if(domChar[s]=='R' && set.contains(s+1) && domChar[s] != domChar[s+1])
                    doneSet.add(s+1);
                else if(domChar[s]=='L' && set.contains(s-1) && domChar[s] != domChar[s-1])
                    doneSet.add(s-1);
                else
                if(domChar[s]=='R' && s+1 < n)
                {
                    
                 if(nextSet.contains(s+1))
                {
                    domChar[s+1]='.';
                    nextSet.remove(s+1);
                }else if(domChar[s+1] !='R'){
                    domChar[s+1]='R';
                    nextSet.add(s+1);
                 }
                }else if(domChar[s]=='L' && s-1 >= 0){
                    
                 if(nextSet.contains(s-1))
                {
                    domChar[s-1]='.';
                    nextSet.remove(s-1);
                }else if(domChar[s-1] !='L'){
                    domChar[s-1]='L';
                    nextSet.add(s-1);
                 }
                }
            }
            set = nextSet;
            
            
        }
        
        return new String(domChar);
    }
}
/*
//".L.R...LR..L.."
 stk
 2
 10
 11
 
 
 . L . R . . . L R . .  L  .  .
 0 1 2 3 4 5 6 7 8 9 10 11 12 13
 
 L L . R R . L L R R L  L  .  .
 0 1 2 3 4 5 6 7 8 9 10 11 12 13 
 -> already contains number remove num and update to . 
 -> num-1 or num+1 exist and both dir not equal remove both
 -> if already down not . then dnt insert
 
 
   L  R L R L
 set 11 8 7 3 1                             
 set  6 4
 q 
 
 
R L . L 
0 1 2 3

set 0 1 3
    1  
    
    R L
    0 1 
set 0 1
    1 0
    
    R L
    1 0 

*/

class Solution {
    public boolean isValidSerialization(String preorder) {
     int slots = 1;
        
        for(String next: preorder.split(",")){
            
            slots--;
            
            if(slots < 0 )
                return false;
            
            if(!next.equals("#"))
                slots += 2;
        }
        
        return slots == 0;
    }
}

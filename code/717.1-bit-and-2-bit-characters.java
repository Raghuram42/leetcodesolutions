class Solution {
    public boolean isOneBitCharacter(int[] bits) {
      if(bits.length == 0)
          return false;
        if(bits.length == 1 && bits[0] == 0)
          return true;
        int f = bits[0];
         // if(bits.length%2 != 0)
         //     return true;
        int prev = bits[0];
        boolean res = true;
        for(int i=1;i<bits.length;i++){
            if(prev == -1)
                prev = bits[i];
            else{
                 if(prev == 1 && bits[i] == 1 || prev == 1 && bits[i] == 0)
                        prev = -1;
                else if(prev == 0 && bits[i] == 1)
                    prev = bits[i];
            }
        }
        return prev == -1 ? false: true;
    }
}
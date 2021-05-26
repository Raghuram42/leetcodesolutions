class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0)
            return true;
        if(flowerbed.length == 1)
            return flowerbed[0] == 0;
        for(int i=0;i<flowerbed.length;i++){
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0)
            {
                flowerbed[i] = 1;
                i++;
                n--;
            }else if(i == flowerbed.length-1 && flowerbed[i] == 0 && flowerbed[i-1] == 0 )
            {
                flowerbed[i] = 1;
                i++;
                n--;
            }
            else if(i > 0 && n >0 && flowerbed[i] == 0 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0){
                flowerbed[i] = 1;
                n--;
                i++;
            }
            if(n == 0){
                return true;
            }
        }
        
        if(n == 0)
            return true;
        
        return false;
        
    }
}
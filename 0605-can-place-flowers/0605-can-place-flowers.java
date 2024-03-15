class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        
        int i = 0;
        
        while(i<l &&  n > 0){
            if(flowerbed[i] == 0 && (i-1 < 0 || flowerbed[i-1] == 0 ) && (i+1 >= l || flowerbed[i+1] == 0 )){
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }
        
        
        return n == 0;
        
        
    }
}
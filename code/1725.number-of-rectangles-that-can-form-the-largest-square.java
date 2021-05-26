class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int max = 0;
        int maxlencount = 0;
        for(int[] rectangle: rectangles){
            int currmaxlen = Math.min(rectangle[0], rectangle[1]);
            if(max < currmaxlen){
                maxlencount = 1;
                max = currmaxlen;
            }else if(max == currmaxlen){
                maxlencount++;
            }
        }
        
        return maxlencount;
    }
}
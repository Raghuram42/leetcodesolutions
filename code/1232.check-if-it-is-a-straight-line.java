class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
          if(coordinates.length == 2)
              return true;
        
        float s = slope(coordinates[0], coordinates[1]);
         int i = 1;
          for(int[] a : coordinates){
             // System.out.println(a[0]+" "+a[1]+" "+" "+slope_up+" "+slope_dw+" "+(coordinates[i][1] - a[1])+" "+(coordinates[i][0] -a[0]));
           //   System.out.println(i+" "+(i<coordinates.length));
              if(i> 1 && i < coordinates.length )
              { 
                  float cslope = slope(a, coordinates[i]);
                  if(s != cslope )
                  return false;
                                         }
              i++;
          }
        return true;
    }
     private float slope(int[] p1, int[] p2) {
        if ((p1[0] - p2[0]) == 0) return 0;
        return (float)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }
}
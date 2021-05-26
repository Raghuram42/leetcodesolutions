class Solution {
    int[][] img;
     int val;
    int colr;
    int[][] map;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        img = image;
        val = image[sr][sc];
        colr = newColor;
        map = new int[image.length][image[0].length];
        fill(sr, sc);
        
          //if((0 <= sr && sr < image.length)){
//         if(image[sr][sc])
//          image = floodFill(image, sr+1 ,sc);
//          image = floodFill(image, sr-1 ,sc);
//           image = floodFill(image, sr ,sc+1);
//           image = floodFill(image, sr ,sc-1);
     return img;
        
    }
    public void fill(int sr, int sc){
        
       
        if((0 <= sr && sr < img.length) && (0 <= sc && sc < img[0].length) && img[sr][sc] == val && map[sr][sc] != 1){
      //        System.out.println(sr+" "+sc);     
            map[sr][sc] = 1;
             img[sr][sc] = colr;
             fill(sr+1 ,sc);
             fill(sr-1 ,sc);
             fill(sr ,sc+1);
             fill(sr ,sc-1);
        }
    }
}
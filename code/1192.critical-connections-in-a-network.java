class Solution {
    int Mod = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
//         int[] arry = new int[k*arr.length];
        
//         for(int i=0;i<arry.length;i++)
//             arry[i] = arr[i%arr.length];
//          // for(int i=0;i<k*arr.length;i++)
//          //    System.out.println(arry[i]);
        int sum = 0;
        int maxsum = 0;
        int min_ind  = 0;
        int max_ind  = 0;
              for(int i=0;i<arr.length;i++){
                  if(sum < arr[i] && sum < 0){
                      sum = 0;
                      min_ind = i;
                  }
            
                  sum += arr[i];
                  if(sum >= maxsum){
                      maxsum = sum;
                      max_ind = i;
                  }
              }
        long leftsum = 0;
        long rightsum = 0;
        long maxleftsum = 0;
        long maxrightsum = 0;
        long totalsum = 0;
        for(int i=0;i<arr.length;i++){
                     totalsum = (totalsum+arr[i])%Mod;
            leftsum = (arr[i]+leftsum)%Mod;
            rightsum = (arr[arr.length-i-1]+rightsum)%Mod;
            maxleftsum = Math.max(leftsum, maxleftsum);
            maxrightsum = Math.max(rightsum, maxrightsum);
   
        }

        if(totalsum <0)
            return Math.max(maxsum, (int)(maxleftsum+maxrightsum)%Mod);
         return Math.max((int)(maxleftsum+maxrightsum+((k-2)*totalsum)%Mod),maxsum);
    }
}

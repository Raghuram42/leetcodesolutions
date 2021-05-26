class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        // for(int i=0;i<num_people;i++)
        //     res[i] = 1;
        int p = 0;
        int k = 1;
        int c =1;
        while(candies-k > 0){
         
            if( p == num_people)
                   p = 0;
            
         res[p] += k;
         candies -= k;
     
         p++;
         if(k == num_people*c){
             k = k+1;  
             c++;
         }
            else
                    k++;
        }
              if( p == num_people)
                   p = 0;
        if(candies>0)
            res[p] += candies;
        
        
        return res;
    }
}
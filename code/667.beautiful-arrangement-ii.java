class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        
        int[] mapr = new int[n+1];
        // k--;
        int i = 1;
        res[0] = n;
        mapr[n] = 1;
        while(i<n && k > 0){
            res[i] = res[i-1]+k <= n && mapr[res[i-1]+k] == 0 ? res[i-1]+k :res[i-1]-k;
            mapr[res[i]] = 1;
            k--;
            i++;
        }
        int ind = 1;
        
            while(i<n && mapr[ind] > 0)
            ind++;
int ind2 = n;
                    while(i<n && mapr[ind2] > 0)
                   ind2--;
   boolean flag = ind > k ? false : true;
        ind = ind2;
      
    while(i<n){
    
        res[i] = ind;
    mapr[ind] = 1;
         while(i<n && mapr[ind] > 0){
             if(flag)
            ind++;
             else
                 ind--;
         }
        
        i++;
        
    }
    
        
        return res;
    }
}
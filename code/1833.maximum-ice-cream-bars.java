class Solution {
    public int maxIceCream(int[] costs, int coins) {
    Arrays.sort(costs);
    int sum = 0;    
    for(int i=0;i<costs.length;i++)    {
        sum += costs[i];
        if(sum > coins)
            return i;
    }
        return costs.length;
        
    }
}
/*
//[1,3,2,4,1]
//[1,1,2,3,4]
//[1,2,3,7,4]

//[10,6,8,7,7,8]
//[6,7,7,8,8,10]
-1 -> 0
    
    //[1,6,3,1,2,5]
    //[1,1,2,3,5,6]
    //[1,2,,4,7,12,18]
    
  */  

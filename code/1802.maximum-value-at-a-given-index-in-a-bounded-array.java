class Solution {
    public int maxValue(int n, int index, int maxSum) {
        // return maxSum%n == 0 ? maxSum/n : (maxSum/n)+1;
        
        
        long l = 1l;
        long r = 0l+maxSum;
        long res = 0;
        while(l<=r){
            long mid = (l+r)/2;
                      long left=Sum(Math.min(index,mid-1),mid); 
            left+=Math.max(0,index-mid+1);  
            
            long right=Sum(Math.min(n-index-1,mid-1),mid);
            right+=Math.max(0,(n-index-mid));
                
                if(mid+left+right <= maxSum){
                res = mid;
                l = mid+1;
            }
            else
                r = mid-1;
            
        }
        
        return (int)res;
    }
       public long Sum(long noofElement,long x){
        return x*(noofElement) - ((noofElement*(noofElement+1))/2);
    }
}

/*
n = 4 index = 2 maxSum = 6
    
Array -> 0 1 2 3 
         10/6
         
n = 2 maxSum = 100
50 50

4
2
6
6
1
10
10
3
100
2
1
100



n = 6 sum = 10

0 -> 10

mid = 5

0 1 2 3 -> 6
1 2 3 4
         */
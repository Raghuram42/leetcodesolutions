class Solution {
    
    public int twoEggDrop(int n) {
        
     int l = 0;
     int r = 50;
        
     while(l<=r){
         int mid = (l+r)/2;//mid = 3 1
         int lft = (mid*(mid+1))/2;//6 1
         int right = ((mid+1)*(mid+2))/2;//10 3
         if(n > lft && n <= right)
             return mid+1;
         else if(n <= lft){
             r = mid-1;
         }else{
             l = mid+1;
         }
         
         
     }   
        return -1;
    }
}
/*
        26    13   6     3
l =     0     0    0     0
r =     50    24   11    4
mid =   25    12   5     2
lft =   325   78   15    3
right = 351   91   21    6
    
    */
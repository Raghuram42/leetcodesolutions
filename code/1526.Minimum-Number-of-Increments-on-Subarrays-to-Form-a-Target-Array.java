class Solution {
    public int minNumberOperations(int[] target) {
       Deque<Integer> stk = new ArrayDeque<>();
        int res = target[0];
        int n = target.length;
        stk.push(0);
        for(int i=1;i<n;i++){
            if( target[i-1] <= target[i]){
                res += target[i]- target[i-1];
            }
            
            
        }
        return res;
    }
}
/*
-2 -1 0 -1 -2
    [1,3,1,5,2,4,1,5,2]
    
    2
    5
    1
    4
    2
    5
    1
    3
    1
res = 1 2 4 2 4


[1,2,3,4,5,6,7]
[7,6,5,4,3,2,1]


   2
   1
res 1 1 1 1 1 1 1
[7,6,5,4,3,2,1]

   654321
   7
res 7
    0 -2 -2 -1
    */

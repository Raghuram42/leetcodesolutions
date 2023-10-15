class Solution {
    public int getSum(int a, int b) {
        int[] map1 = new int[33];
        // int[] map2 = new int[33];
        
        int ans = 0;
        int i = 0;
        boolean neg1 = false;
        if(a <0){
            neg1 = true;
            a = a*-1;
        }
        boolean neg2 = false;
        if(b<0){
            neg2 = true;
            b = b*-1;
        }
        while(i<31){
            int p = 1<<i;
            // System.out.println(p+" "+(a&p)+" "+(b&p));
            ans +=  (a&p) == p  ? (neg1 ? -p : p): 0;
            ans +=  (b&p) == p  ? (neg2 ? -p : p): 0;
            i++;
        }
        
        
        
        return ans;
    }
}
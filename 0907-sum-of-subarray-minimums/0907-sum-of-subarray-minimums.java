class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        
        int i = 0;
        int n = arr.length;
        int[] left = new int[n];
        while(i<n){
              while(!stk.isEmpty() && arr[i] <= arr[stk.peek()])
                stk.pop();
            left[i] = stk.isEmpty() ? i : i-stk.peek()-1;
         
            
            stk.push(i);
            i++;
        }
        
        stk = new Stack<>();
        // System.out.println(Arrays.toString(left));
        i = n-1;
        long ans = 0;
        while(i>=0){
            
            while(!stk.isEmpty() && arr[i] < arr[stk.peek()])
                stk.pop();
            int curr = stk.isEmpty() ? n-i-1 : stk.peek()-1-i;
            ans = mod(ans+mod(mod(mod(mod(mod(left[i]*curr)*arr[i]))+mod(left[i]+0l+curr+1)*arr[i])));
            // System.out.println(curr+ " "+ans+" "+mod(mod(mod(left[i]*curr)+mod(left[i]+curr+1))*arr[i]));
            stk.push(i);
            i--;
        }
        return (int)ans;
        
    }
    public long mod(long v){
        return (v%1000000007);
    }
}
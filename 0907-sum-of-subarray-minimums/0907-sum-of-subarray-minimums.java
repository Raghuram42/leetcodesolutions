class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Calculate left boundaries for each element
        for (int i = 0; i < n; i++) {
            while (!leftStack.isEmpty() && arr[i] <= arr[leftStack.peek()]) {
                leftStack.pop();
            }
            left[i] = leftStack.isEmpty() ? i + 1 : i - leftStack.peek();
            leftStack.push(i);
        }
        
        // Calculate right boundaries for each element
        for (int i = n - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && arr[i] < arr[rightStack.peek()]) {
                rightStack.pop();
            }
            right[i] = rightStack.isEmpty() ? n - i : rightStack.peek() - i;
            rightStack.push(i);
        }
        
        long ans = 0;
        int modValue = 1000000007;
        
        for (int i = 0; i < n; i++) {
            ans += (long)arr[i] * left[i] * right[i];
            ans %= modValue;
        }
        
        return (int)ans;
    }
}

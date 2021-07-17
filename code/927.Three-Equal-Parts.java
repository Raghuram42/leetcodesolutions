class Solution {
    public int[] threeEqualParts(int[] arr) {
        int ones = 0;
        int n = arr.length;
        for(int i=0;i<n;i++)
            ones += arr[i] == 1 ? 1: 0;
        
        int[] notPos = new int[]{-1, -1};
        if(ones == 0)
            return new int[]{0, n-1};
        
        if(ones%3 != 0)
            return notPos;
        
        int k = ones/3;
        int st = getNthOneIndex(arr, 1);
        int mid = getNthOneIndex(arr, k+1);
        int end = getNthOneIndex(arr, 2*k +1);
        
        while(end < n && arr[st] == arr[mid] && arr[mid] == arr[end]){
            end++;
            st++;
            mid++;
        }
        
        return end == n ? new int[]{st-1, mid} : notPos;
    }
    
    public int getNthOneIndex(int[] arr, int k){
        int n = arr.length;
        int i = 0;
        int count = 0;
        while(i<n && count != k)
        {
            count += arr[i] == 1 ? 1 : 0;
            i++;
        }
        
        return i;
    }
}

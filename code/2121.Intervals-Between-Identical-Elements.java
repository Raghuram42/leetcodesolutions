class Solution {
    public long[] getDistances(int[] arr) {
        int n = arr.length;
        int[][] inp = new int[n][2];
        
        for(int i=0;i<n;i++)
            inp[i] = new int[]{arr[i], i};
        
        Arrays.sort(inp, (a,b)->a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        long[] res = new long[n];
        long[][] left = new long[n][2];
        long[][] right = new long[n][2];
        
        
        int i = 0;
        while(i<n){
            int curr = inp[i][0];
            long v = 0;
            long prev = 0;
            while(i<n && curr == inp[i][0]){
                left[i][0] += prev+inp[i][1];
                left[i][1] += v+1;
                prev = left[i][0];
                v = left[i][1];
                i++;
            }
        }
        
        
        
        i = n-1;
        while(i>=0){
            int curr = inp[i][0];
            long v = 0;
            long prev = 0;
            while(i>=0 && curr == inp[i][0]){
                right[i][0] += prev+inp[i][1];
                right[i][1] += v+1;
                v = right[i][1];
                prev = right[i][0];
                i--;
            }
        }
        
        
        i = 0;
        
        while(i<n){
            res[inp[i][1]] = (right[i][0]-inp[i][1])-inp[i][1]*(right[i][1]-1)+(inp[i][1]*(left[i][1]-1)-(left[i][0]-inp[i][1]));
            i++;
        }
        
        return res;
        
    }
}

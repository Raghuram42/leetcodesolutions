class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int next: arr){
            map.put(next, map.getOrDefault(next, 0)+1);
        }
        int n = map.size();
        int[][] freq = new int[n][2];
        int i = 0;
        for(Integer next: map.keySet())
            freq[i++] = new int[]{next, map.get(next)};
        
        Arrays.sort(freq, (a, b)->a[1]-b[1]);
        
        i = 0;
        while(k>0)
            k-=freq[i++][1];
        
        if(k == 0)
            return n-i;
        
        return n-i+1;
    }
}
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> hsm = new HashMap<Integer, int[]>();
        
        for(int[] pc: pieces)
            hsm.put(pc[0], pc);
        
        int i = 0;
        
        while(i<arr.length){
            if(!hsm.containsKey(arr[i]))
                return false;
            
            int[] curr = hsm.get(arr[i]);
            // i++;
            int p = 0;
            while(i<arr.length && p < curr.length){
                if(arr[i] != curr[p])
                    return false;
                i++;
                p++;
            }
        }
        return true;
        
        
    }
}
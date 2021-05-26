class Solution {
    public int[] decode(int[] encoded, int first) {
        // if(f)
        int[] res = new int[encoded.length+1];
        res[0] = first;
        
        for(int i=1;i<res.length;i++)
            res[i] = encoded[i-1]^res[i-1];
        return res;
    }
}
class Solution {
    HashMap<Integer, Integer> hsm;
    public int getKth(int lo, int hi, int k) {
        hsm = new HashMap<Integer, Integer>();
        int[][] tempres = new int[hi-lo+1][2];
        int p=0;
        for(int i=lo;i<=hi;i++){
            if(!hsm.containsKey(i))
                tempres[p][0] = solve(i);
            else
                tempres[p][0] = hsm.get(i);
            tempres[p++][1] = i;
        }
        Arrays.sort(tempres, new Comparator<int[]>(){
            @Override
            public int compare(int[] f, int[] s){
                return f[0]-s[0];
            }
        });
        // System.out.println(hsm);
        return tempres[k-1][1];
    }
    
    public int solve(int i){
        
        if(i == 1)
            return 0;
        
        if(hsm.containsKey(i))
            return hsm.get(i);
        int res = 1+solve(i%2 == 0 ? i/2 : (i*3) +1);
        hsm.put(i, res);
        return res;
    }
}
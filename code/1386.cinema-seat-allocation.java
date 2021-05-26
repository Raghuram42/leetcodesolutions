class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, int[]> hsm = new HashMap<Integer, int[]>();
        int nof =0;
        
        for(int[] res: reservedSeats){
            if(!hsm.containsKey(res[0])){
                hsm.put(res[0], new int[11]);
                nof++;
            }
            
            hsm.get(res[0])[res[1]]++;
        }
        
        // res += ;
        // int i=1;
        int res = (n-nof)*2;
        
        for(int i: hsm.keySet()){
                // int tempres = 0;
                int[] temp = hsm.get(i);
                
                List<Integer> curr = new ArrayList<>();
                
                for(int k=1;k<=10;k++)
                    if(temp[k] > 0)
                    curr.add(k);
                // Collections.sort(curr);
                int prev = 0;
                int sz = curr.size()+1;
                for(int p=0;p<sz;p++){
                    int tempres = 0;
                    int current =  p == sz-1 ? 11 : curr.get(p);
                    boolean isusedfir = false;
                    boolean isusedsec = false;
                    if(prev<2 && current > 5){
                        tempres++;
                        isusedfir = true;
                    }
                    if(prev < 6 && current > 9){
                        tempres++;
                        isusedsec = true;
                    }
                    if(prev < 4 && current > 7 && !isusedfir && !isusedsec)
                        tempres++;
                    
                    res += tempres;
                    if(p != sz-1)
                    prev = curr.get(p);
                }
        }
        return res;
    }
}
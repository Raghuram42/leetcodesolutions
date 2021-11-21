class RangeFreqQuery {
    HashMap<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<Integer, List<Integer>>();
        int n = arr.length;
        for(int i=0;i<n;i++)
        {
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList<Integer>());
            
            map.get(arr[i]).add(i);
        }
        System.out.println(map);
    }
    
    public int query(int left, int right, int value) {
        if(!map.containsKey(value))
            return 0;
        int leftInd = bsearch(map.get(value), left);
        int rightInd = bsearch2(map.get(value), right);
        // System.out.println(leftInd+" "+rightInd);
        int n = map.get(value).size();
        if(leftInd == -1)
            return 0;
        if(leftInd == n)
            return 0;
        return rightInd-leftInd+1;
    }
    
    
    public int bsearch(List<Integer> inp, int tar){
        int l = 0;
        int r = inp.size()-1;
        int ans = -1;
        
        while(l<=r){
            int mid = (l+r)/2;
                
            if(tar <= inp.get(mid)){
                ans = mid;
                r = mid-1;
            }else
            {
                l = mid+1;
            }    
        }
        
        return ans;
    }
    
    
    
    public int bsearch2(List<Integer> inp, int tar){
        int l = 0;
        int r = inp.size()-1;
        int ans = -1;
        
        while(l<=r){
            int mid = (l+r)/2;
                
            if(tar < inp.get(mid)){
                
                r = mid-1;
            }else
            {
                ans = mid;
                l = mid+1;
            }    
        }
        
        return ans;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */

class RecentCounter {
    ArrayList<Integer> arry;
    int count;
    public RecentCounter() {
        count = 0;
        arry = new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        int t1 = t-3000;
        arry.add(t);
        if(t1 < 0)
            return arry.size();
        
        return bnsearch(arry, t1);        
    }
    public int bnsearch(ArrayList<Integer> arry, int target){
        
        int l = 0;
        int r = arry.size()-1;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(arry.get(mid) == target)
                return arry.size()-mid;
            else if(arry.get(mid) > target)
                r = mid-1;
            else
                l = mid +1;
                
        }
    //    System.out.println(l+" "+target+" "+arry);
        return arry.size()-l;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
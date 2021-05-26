class Solution {
    public List<Integer> pancakeSort(int[] A) {
        
        int n = A.length;
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i=0;i<A.length;i++){
            int ind = findind(A, n);
            
            flip(A, ind);
            flip(A, n-1);
            
            res.add(ind+1);
            res.add(n);
            n--;
        }
        
        return res;
    }
    
    public int findind(int[] A, int n){
        
        for(int i=0;i<A.length;i++){
            if(A[i] == n)
                return i;
        }
        return 0;
    }
    
    public void flip(int[] A, int n){
        int l = 0;
        
        while(l<n){
            int tmp = A[l];
            A[l++] = A[n];
            A[n--] = tmp;
        }
        
    }
}
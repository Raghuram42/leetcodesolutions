class Solution {
    public int hIndex(int[] citations) {
         int start = 0;
        int end = citations.length-1;
        int mid=0;
        int n = citations.length;
        int h = n;
        if(n==0 || n==1 && citations[0]==0)
            return 0;
        if(n==1)
            return 1;
        while(start<=end)
        {
            mid= start+ (end-start)/2;
            h= n-mid;
            if(mid>0 && citations[mid]>=h && citations[mid-1]>h)
                end =mid-1;
            else if(citations[mid]>=h )
            {
                return h;
            }
            else
                start=mid+1;
        }
        return 0; 
    }
}
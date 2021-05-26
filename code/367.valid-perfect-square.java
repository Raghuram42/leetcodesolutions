
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        ArrayList<int[]> russiandoll = new ArrayList<int[]>();
           Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] left, int[] right) {
                if (left[0] == right[0]) {
                    if (left[1] == right[1]) {
                        return 0;
                    }
                    return left[1] < right[1] ? 1 : -1;
                }
                return left[0] < right[0] ? -1 : 1;
            }
           });
               
        for(int[] envelop: envelopes)
            addenv(russiandoll, envelop);
        
        return russiandoll.size();
    }
    public void addenv(ArrayList<int[]> russiandoll, int[] envelop ){
        if(russiandoll.size() == 0 || russiandoll.get(russiandoll.size()-1)[1] < envelop[1]){
            russiandoll.add(envelop);
        }
        else{
           int ind = bsearch(russiandoll, envelop);
            russiandoll.set(ind, envelop);
        }
        
    }
    public int bsearch(ArrayList<int[]> russiandoll, int[] targetenvelop){
        
        int l = 0;
        int r = russiandoll.size()-1;
        
        while(l<=r){
            int mid = (l+r)/2;
           // if(russiandoll.get(mid)[0] == targetenvelop[0]){
                if(russiandoll.get(mid)[1] == targetenvelop[1])
                    return mid;
                else if(russiandoll.get(mid)[1] < targetenvelop[1])
                    l = mid+1;
                else
                    r = mid-1;
            // }
            // else if(russiandoll.get(mid)[0] < targetenvelop[0]){
            //     l = mid+1;
            // }
            // else{
            //     r = mid-1;
            // }
        }
        return l;
    }
}
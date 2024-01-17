class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] mp = new int[3000];
        
        for(int a: arr)
            mp[a+1000]++;
        
        Arrays.sort(mp);
        
        for(int i=1;i<3000;i++){
            if(mp[i] > 0){
                if(mp[i-1] == mp[i])
                    return false;
            }
        }
        
        return true;
    }
}
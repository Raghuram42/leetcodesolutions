class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0;i<ranges.length;i++){
            
            int st = ranges[i][0];
            int end = ranges[i][1];
            while(st<=end)
                set.add(st++);
        }
        
        
        while(left<=right){
            if(!set.contains(left++))
                return false;
        }
        return true;
    }
}
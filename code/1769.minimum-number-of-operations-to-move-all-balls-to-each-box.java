class Solution {
    public int[] minOperations(String boxes) {
        int[] res = new int[boxes.length()];
        
        for(int i=0;i<boxes.length();i++){
            for(int j=0;j<boxes.length();j++){
                if(i != j){
                    res[i] += boxes.charAt(j) == '1' ? Math.abs(j-i): 0;
                }
            }
        }
        
        return res;
    }
}
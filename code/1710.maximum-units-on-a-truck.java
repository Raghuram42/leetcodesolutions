class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                
                return b[1]-a[1];
            }
        });
        
        int res = 0;
        for(int i=0;i<boxTypes.length;i++){
            if(truckSize-boxTypes[i][0] >=0){
                truckSize= truckSize-boxTypes[i][0];
                res += boxTypes[i][0]*boxTypes[i][1];
            }else{
                res += truckSize*boxTypes[i][1];
                break;
            }
        }
        return res;
        
        
        
    }
}
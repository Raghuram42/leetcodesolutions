class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] mapr = new int[1001];
        for(int n: arr1)
            mapr[n]++;
        
        int p =0;
        for(int i=0;i<arr2.length;i++)
        {
            while(mapr[arr2[i]] > 0){
            arr1[p++] = arr2[i];
                mapr[arr2[i]]--;
            }
        }
        
        
        // Arrays.sort(arr1);
        
        for(int i=0;i<1001;i++)
            while(mapr[i] > 0){
                mapr[i]--;
                arr1[p++]=i;
            }
                // arr1[i] = arr1[i]%10000;
        
        
        return arr1;
                
    }
}
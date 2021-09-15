class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int res = 0;
        int n = arr.length;
        int i =0;
        boolean greater = false;
        int tres = 0;
        while(i+1<n){
            if(!greater && arr[i] < arr[i+1]){
                tres++;
                greater = true;
            }else if(greater && arr[i] > arr[i+1]){
                tres++;
                greater = false;
            }else if(arr[i] == arr[i+1]){
                tres = 0;
            }else { 
                greater = !greater;
                   tres = 0;
                   continue;
                  }
            res = Math.max(tres, res);
            i++;
        }
        
        return res+1;
    }
}

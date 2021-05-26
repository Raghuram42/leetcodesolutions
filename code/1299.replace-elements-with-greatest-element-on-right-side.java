class Solution {
    public int[] replaceElements(int[] arr) {
        int g_ele = -1;
        
        for(int i=arr.length-1;i>=0;i--){
            int t = arr[i];
            arr[i] = g_ele;
            
            if(t>g_ele)
                g_ele = t;
        }
        return arr;
    }
}
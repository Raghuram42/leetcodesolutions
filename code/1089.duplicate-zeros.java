class Solution {
    public void duplicateZeros(int[] arr) {
          int temp = arr[0];
         int[] des = new int[arr.length];
          int ns = 0;
          boolean swap = false;
        
        for(int i=0;i<arr.length && ns<arr.length;i++){
            if(arr[i] == 0){
                des[ns] = 0;
                des[ns++] = 0;
            }
            else
            des[ns] = arr[i];
            ns++;
        }
     for(int i=0;i<arr.length;i++)
         arr[i]= des[i];
     
}
}
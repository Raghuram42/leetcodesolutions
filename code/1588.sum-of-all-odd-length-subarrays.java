class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        for(int i=1;i<arr.length;i++)
            arr[i] += arr[i-1];
        int sum = arr[arr.length-1];
        
        for(int i=2;i<arr.length;i++){
          for(int j=0;j<arr.length && j<i;j++){
              if((i-j+1)%2 == 1){
                  sum += arr[i];
                 if(j!=0)
                     sum-= arr[j-1];
              }
          }
    }
        return sum;
    }
}
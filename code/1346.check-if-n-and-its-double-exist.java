class Solution {
    public boolean checkIfExist(int[] arr) {
//         HashSet<Integer> hst = new HashSet<Integer>();
//         for(int i=0;i<arr.length;i++)
//             hst.add(arr[i]);
        
//         for(int i=0;i<arr.length;i++){
//             if(hst.contains(2*arr[i]))
//                 return true;
//         }
        
        for(int i=0;i<arr.length;i++){
            for(int j =0;j<arr.length;j++)
            {
                if(i != j && arr[i] == arr[j] * 2)
                    return true;
            }
        }
        return false;
    }
}
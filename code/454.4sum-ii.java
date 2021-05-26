class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        // Arrays.sort(D);
        // HashMap<>
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                hsm.put(A[i]+B[j], hsm.getOrDefault(A[i]+B[j], 0)+1);
            }
        }
         HashMap<Integer, Integer> hsm2 = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                hsm2.put(C[i]+D[j], hsm2.getOrDefault(C[i]+D[j], 0)+1);
            }
        }
        
        Set<Integer> hst = hsm.keySet();
        for(int nu: hst){
            if(hsm2.containsKey(nu*-1))
                res += hsm2.get(nu*-1)*hsm.get(nu);
        }
     // for(int i=0;i<A.length;i++)  {
     // for(int j=0;j<A.length;j++)  {
     //  for(int k=0;k<A.length;k++)  {
     //  for(int l=0;l<A.length;l++)  {
     //     if(A[i]+B[j]+C[k]+D[l] == 0)
     //         res++;
     // }  
          
     // }   
     // }    
     // }
        return res;
    }
}
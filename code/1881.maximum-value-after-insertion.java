class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        double ans = -1;
        
        int l = 1;
        int end = 10000000;
        
        while(l<=end){
            int mid = (l+end)/2;
            
            double kms = 0;
            for(int i=0;i<dist.length-1;i++)
                kms += Math.ceil(dist[i]*1d/mid);
            
            kms += dist[dist.length-1]*1d/mid;
            // System.out.println(kms+" "+hour+" "+mid);
            if(kms > hour){
                l = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
            
        }
        
        return (int)ans;
    }
}
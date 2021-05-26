/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int l = 1;
        int right = n;
        
        while(l < right){
            int mid = l+(right-l)/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else{
                l = mid+1;
            }
        }
        //for(int i=1;i<=n;i++)
        //System.out.println(isBadVersion(i));
        return l;
    }
}
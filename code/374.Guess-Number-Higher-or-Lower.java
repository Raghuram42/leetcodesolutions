/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1;
        int r = n;
        
        while(l<=r){
            int mid = l+((r-l)/2);
            
            int guessNum = guess(mid);
            // System.out.println(mid +" "+guessNum);
            if(guessNum == 0)
                return mid;
            else if(guessNum == 1)
                l = mid+1;
            else
                r = mid-1;
            
        }
        
        return -1;
    }
}

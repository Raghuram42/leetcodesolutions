class Solution {
    public double angleClock(int hour, int minutes) {
        int min_dif = minutes;
       if(minutes == 0)
           min_dif = 60;
        if(hour == 12)
            hour = 0;
        // if(hour > min_dif/5.00)
        //     return (12.00-hour-(min_dif/5.00)) *30.00 -(minutes*1.00/2);
          double hour_angle = (0.500 * (hour*60.00 + minutes)); 
        double minute_angle = (6.00*minutes); 
  
        double res = Math.abs(hour_angle-minute_angle);
     return Math.min(360-res, res);
    }
}
import java.util.Calendar;
import java.time.*;  
class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
         LocalDate localDate = LocalDate.of(year, month, day);

    String dayOfWeek = localDate.getDayOfWeek().toString();
    // System.out.println(dayOfWeek);

    return Character.toUpperCase(dayOfWeek.charAt(0))+dayOfWeek.substring(1).toLowerCase();
        
    }
}
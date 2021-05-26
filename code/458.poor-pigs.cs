public class Solution
{
  public int PoorPigs(int buckets, int minutesToDie, int minutesToTest)
  {
    var t = minutesToTest / minutesToDie + 1;

    var exp = 0;
    for (;;)
    {
      var pow = (int)Math.Pow(t, exp);
      if (pow >= buckets)
        return exp;
      
      exp++;
    }
  }
}
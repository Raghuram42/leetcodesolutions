class Solution {
public:
   vector<int> findRightInterval(vector<vector<int>>& intervals) {
      int n = intervals.size();
      vector <int> ret(n, -1);
      map <int, int> m;
      for(int i = 0; i < intervals.size(); i++){
         if(m.count(intervals[i][0])) continue;
         m[intervals[i][0]] = i + 1;
      }
      for(int i = n - 1; i >= 0; i--){
         map <int, int> :: iterator it = m.lower_bound(intervals[i][1]);
         if(it->second == 0) continue;
         ret[i] = it->second - 1;
      }
      return ret;
   }
};
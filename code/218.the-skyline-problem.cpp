class Solution {
public:
    vector<vector<int>> merge_sky_lines(vector<vector<int>>& leftSkyLine, vector<vector<int>>& rightSkyLine) {
        vector<vector<int>> mergedSkyLine;
        int i = 0, j = 0;
        int h1 = 0;
        int h2 = 0;
        int skyX = 0, skyH = 0;
        while(i < leftSkyLine.size() && j < rightSkyLine.size()) {
            vector<int> s1     = leftSkyLine[i];
            vector<int> s2     = rightSkyLine[j];
            //choose the one having less value for x co-ordinate
            if(s1[0] < s2[0]) {
                h1   = s1[1];
                skyX = s1[0];
                i++;
            } else if(s2[0] < s1[0]) {
                h2   = s2[1];
                skyX = s2[0];
                j++;
            } else {
                h1   = s1[1];
                h2   = s2[1];
                skyX = s1[0];
                i++;
                j++;
            }
            
            //I will only add a new point when my last max height(skyH) is changed
            //Because, lower height would be overshadowed
            if(skyH != max(h1, h2)) {
                skyH = max(h1, h2);
                mergedSkyLine.push_back({skyX, skyH});
            }
        }
        
        while(i < leftSkyLine.size()) {
            mergedSkyLine.push_back(leftSkyLine[i]);
            i++;
        }
        
        while(j < rightSkyLine.size()) {
            mergedSkyLine.push_back(rightSkyLine[j]);
            j++;
        }
        
        return mergedSkyLine;
    }
    vector<vector<int>> merge_sort_sky_line(int low, int high, vector<vector<int>>& buildings) {
        vector<vector<int>> skyLine;
        if(low > high)
            return skyLine;
        
        if(low == high) {
            int x1 = buildings[low][0];
            int x2 = buildings[low][1];
            int h  = buildings[low][2];
            
            skyLine.push_back({x1, h});
            skyLine.push_back({x2, 0});
            
            return skyLine;
        } else {
            int mid = low + (high-low)/2;
            vector<vector<int>> left_sky_line  = merge_sort_sky_line(low, mid, buildings);
            vector<vector<int>> right_sky_line = merge_sort_sky_line(mid+1, high, buildings);
            
            return merge_sky_lines(left_sky_line, right_sky_line);
        }
    }
    vector<vector<int>> getSkyline(vector<vector<int>>& buildings) {
        int n = buildings.size();
        
        vector<vector<int>> mergedSkyLine = merge_sort_sky_line(0, n-1, buildings);
           
        return mergedSkyLine;
    }

};
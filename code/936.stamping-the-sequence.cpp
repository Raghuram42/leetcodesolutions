class Solution {
public:
     vector<int> movesToStamp(string stamp, string target) {
        //reverse operation: matched then change it to ***
        //until we change the target string into *****
        //note we can only match one end if it is covered
        int n=target.length();
        string final(n,'*');
        vector<int> ans;
        while(target!=final)
        {
            int ind=match_change(target,stamp);
            if(ind==-1) return vector<int>();
            ans.push_back(ind);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
    int match_change(string& target,string stamp)
    {
        //find the first matching and return
        //at least has one non * char inside, * matches any char
        bool matched=0;
        for(int i=0;i<target.size();i++)
        {
            int cnt_match=0;
            int j=0;
            for(j=0;j<stamp.size();j++)
            {
                if(target[i+j]=='*') continue;
                if(target[i+j]==stamp[j]) cnt_match++;
                else break;
            }
            if(j==stamp.size()&& cnt_match) 
            {
                for(j=0;j<stamp.size();j++) target[i+j]='*';
                return i;
            }
        }
        return -1; //no matching
    }
};
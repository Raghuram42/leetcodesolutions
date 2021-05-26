class Solution {
public:
    vector<string> wordSubsets(vector<string>& A, vector<string>& B) {
        vector<string>s;
        map<char,int>m1;
        int n=0;
        for(int i=0;i<B.size();i++){
            map<char,int>m2;
            for(int j=0;j<B[i].size();j++){
                
                m2[B[i][j]]++;}
            for(auto it:m2)
            {
                
                m1[it.first]=max(it.second,m1[it.first]);
            }
        }
        n=m1.size();
        
        for(int i=0;i<A.size();i++){
            int c=0;
            map<char,int>m2;
            for(int j=0;j<A[i].size();j++)
            {
                
                m2[A[i][j]]++;
            }
           
            for(auto it:m1)
            {
                if(m2[it.first]>=it.second)
                    c++;
                else
                    break;
            }
            if(n==c)
                s.push_back(A[i]);
        }
            
        return s;
    }
};
class Solution {
    boolean vis[];
    List<String> res;
    public List<String> invalidTransactions(String[] transactions) {
        vis = new boolean[transactions.length];
        res = new ArrayList<String>();
        for(int i=0;i<transactions.length;i++){
            
        String[] currTransaction = transactions[i].split(",");
            for(int j=i+1;j<transactions.length;j++){
                String[] nextTransaction = transactions[j].split(",");
             // solve(transactions, i, transactions[i]);
                  if(currTransaction[0].equals(nextTransaction[0]) && Math.abs(Integer.parseInt(currTransaction[1])-Integer.parseInt(nextTransaction[1])) <= 60 && !(currTransaction[3].equals(nextTransaction[3])))
                {
                      vis[i] = true;
                      vis[j]= true;
                  }
                
            }
            
            if(Integer.parseInt(currTransaction[2]) > 1000 )
            // res.add(transactions[i]);
            vis[i] = true;
        }
        
        for(int i=0;i<transactions.length;i++)
            if(vis[i])
                res.add(transactions[i]);
        return res;
        
    }
    
    public void solve(String[] transactions, int i, String currTrans){
        
        boolean invalid = false;
        String[] currTransaction = currTrans.split(",");
        for(int j=i+1;j<transactions.length;j++){
            
            String[] nextTransaction = transactions[j].split(",");
                if(currTransaction[0].equals(nextTransaction[0]) && Math.abs(Integer.parseInt(currTransaction[1])-Integer.parseInt(nextTransaction[1])) <= 60 && !(currTransaction[3].equals(nextTransaction[3])))
                {
                    
                 vis[j] = true;
                 solve(transactions, j, transactions[j]);                    
                 
                vis[i] = true;
                }   
        }
            if(Integer.parseInt(currTransaction[2]) > 1000 || invalid)
            // res.add(transactions[i]);
            vis[i] = true;
        
    }
}
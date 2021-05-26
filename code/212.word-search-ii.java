class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    char[][] boards;
    //boolean[][] vis;
    public List<String> findWords(char[][] board, String[] words) {
        
        HashMap<Character, Queue<Pair>> hsm = new HashMap<Character, Queue<Pair>>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!hsm.containsKey(board[i][j]))
                    hsm.put(board[i][j], new LinkedList<Pair>());
                
                hsm.get(board[i][j]).offer(new Pair(i, j));
            }
        }
       // System.out.println(hsm);
        boards = board;
        List<String> res = new ArrayList<String>();
       boolean[][]  vis = new boolean[board.length][board[0].length];
        for(String str : words){
                if(str.length() > 0 && hsm.containsKey(str.charAt(0))){
                    Queue <Pair> temp = hsm.get(str.charAt(0));
                    int sz = temp.size();
                    
                    while(sz > 0){
                        Pair curr = temp.poll();
                        vis = new boolean[board.length][board[0].length];
                        if(dfs(curr.i, curr.j, str, 0, vis)){
                            res.add(str);
                            temp.offer(curr);
                            break;
                        }
                        temp.offer(curr);
                        sz--;
                    }
                }
        
        }
        return res;
    }
    
    public boolean dfs(int i,int j, String str, int cu, boolean vis[][]){
        if(i<0 || j<0 || i>= boards.length || j >= boards[0].length || cu >= str.length())
            return false;
      //  System.out.println(boards[i][j] +" "+str.charAt(cu)+" "+cu+" : "+(boards[i][j] == str.charAt(cu)));
        if(vis[i][j])
            return false;
        
        if(boards[i][j] == str.charAt(cu) && cu == str.length()-1){
           return true;
        }
        else if(boards[i][j] == str.charAt(cu)){
            vis[i][j] = true;
            if(dfs(i-1, j, str, cu+1, vis) || dfs(i, j+1, str, cu+1, vis) || dfs(i+1, j, str, cu+1, vis) || dfs(i, j-1, str, cu+1, vis)){
                return true;
            }
        }
        vis[i][j] = false;
        return false;
        
    }
}
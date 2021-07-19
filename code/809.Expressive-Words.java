class Solution {
    class Word{
        char c;
        int count;
        
        Word(char c, int count ){
            this.c = c;
            this.count = count;
        }
        @Override
        public String toString(){
            return this.c+" count "+this.count;
        }
    }
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        List<Word> root = getWp(s);
        List<List<Word>> wrdCount = new ArrayList<>();
        for(String w: words){
          wrdCount.add(getWp(w));
        }
        // System.out.println(root);
        // System.out.println(wrdCount);
        for(List<Word> w: wrdCount){
          if(same(w, root))
              res++;
        }
        
        
        return res;
    }
    
    public List<Word> getWp(String w){
        
        int i = 0;
        int n = w.length();
        char curr = w.charAt(0);
        List<Word> res = new ArrayList<>();
        while( i < n){
            int c = 1;
            while( i+1 < n && curr == w.charAt(i+1)){
                c++;
                i++;
            }
            
            res.add(new Word(curr, c));
            if(i+1<n)
            curr = w.charAt(i+1);
            
                i++;
                
        }
        return res;
    }
    public boolean same(List<Word> w, List<Word> s){
        if(w.size() != s.size())
            return false;
        int i = 0;
        int j = 0;
        
        int sLen = s.size();
        int wLen = w.size();
        
        while(i<sLen  && j<wLen){
          if(w.get(i).c == s.get(i).c && (w.get(i).count == s.get(i).count  || s.get(i).count >= 3 && w.get(i).count-s.get(i).count <=0 )){
              i++;
              j++;
          }else
              return false;
        }
        
        return true;
    }
}

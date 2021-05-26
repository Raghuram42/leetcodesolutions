class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
     boolean n = true;    
        boolean w = false;
        boolean e = false;
        boolean s = false;
        
    public boolean isRobotBounded(String instructions) {
        Pair cordn = new Pair(0,0);
       
        int c = 0;
        
        while(c <2 *instructions.length()){
            for(int i=0;i<instructions.length();i++){
                if(instructions.charAt(i) == 'G'){
                    move(cordn);
                }
                else
                    changedirec(instructions.charAt(i));
               // System.out.println(cordn.x +" "+ cordn.y);
            }
            
                         if(cordn.x == cordn.y && cordn.x ==0)
                   return true;
            c++;
        }
        
        
        
        return false;
    }
    public void move(Pair cordn){
        if(n){
            cordn.y++;
        }else if(e){
            cordn.x++;
        }else if(s)
            cordn.y--;
            else
                cordn.x--;
    }
    
    public void changedirec(char dir){
           if(dir == 'L')
           {
               if(n){
            n = !n;
                  w = !w; 
        }else if(e){
            e = !e;
                   n =!n;
        }else if(s)
               {
                   s = !s;
                   e = !e;
               }
            else
            {
                w = !w;
                s = !s;
            }
           }
        else{
                 if(n){
            n = !n;
                  e = !e; 
        }else if(e){
            e = !e;
                   s =!s;
        }else if(s)
               {
                   s = !s;
                   w = !w;
               }
            else
            {
                w = !w;
                n = !n;
            }
        }
    }
}
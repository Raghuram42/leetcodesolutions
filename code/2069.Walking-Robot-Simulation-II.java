class Robot {
    int st;
    int end;
    int w;
    int h;
    String dir;    
    public Robot(int width, int height) {
        st = 0;
        end = 0;
        w = width;
        h = height;
        dir = "East";
    }
    
    public void move(int num) {
        // System.out.println(Arrays.toString(getPos())+" "+dir);
        int org = num;
        num = num%((2*w+2*h)-4);
        // System.out.println(num);
        if(num == 0){
            // changeDir();
            if(st == 0 && end == 0 && org > 0)
            {
                
                dir = "South";
                
            }
            return;
        }
        if(dir.equals("East")){
        if(end+num < w){
            end += num;
            return;
        }else{
            changeDir();
            int nextM = Math.abs((w-end-1)-num);
            end = w-1;
            move(nextM);
        }    
            
            
        }else if(dir.equals("West")){
            if(end-num >= 0){
                end = end-num;
                return;
            }else{
                changeDir();
                int nextM = Math.abs(end-num);
                end = 0;
                move(nextM);
            }
        }else if(dir.equals("South")){
            if(st-num >=0){
                st-=num;
                return;
            }else{
                changeDir();
                int nextM = Math.abs(st-num);
                st = 0;
                move(nextM);
            }
        }else{
            if(st+num < h){
                st += num;
                return;
            }else{
                changeDir();
                int nextM = Math.abs((h-st-1)-num);
                st = h-1;
                move(nextM);
            }
        }
     // System.out.println(Arrays.toString(getPos())+" "+dir);   
    }
    public void changeDir(){
        if(dir.equals("East"))
            dir = "North";
        else if(dir.equals("North"))
         dir = "West";
        else if(dir.equals("West"))
            dir = "South";
        else
            dir = "East";
        
        return;
    }
    public int[] getPos() {
        return new int[]{end, st};
    }
    
    public String getDir() {
        return dir;
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.move(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */

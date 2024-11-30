class Solution {
    public int romanToInt(String s) {
        int n=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='C'){
                if((i+1)<s.length() && s.charAt(i+1)=='M'){
                n+=900;
                i++;
                continue;
                }
                else if((i+1)<s.length() && s.charAt(i+1)=='D'){
                n+=400;
                i++;
                continue;
                }
                else{
                n+=100;
                continue;}
            }
            if(s.charAt(i)=='M'){
            n+=1000;
            continue;
            }

            if(s.charAt(i)=='D'){
            n+=500;
            continue;
            }

            if(s.charAt(i)=='X'){
                if((i+1)<s.length() && s.charAt(i+1)=='C'){
                n+=90;
                i++;
                continue;
                }
                else if((i+1)<s.length() && s.charAt(i+1)=='L'){
                n+=40;
                i++;  
                continue;
                }
                else{
                n+=10;
                continue;}
            }
            if(s.charAt(i)=='L'){
            n+=50;
            continue;
            }
            
            if(s.charAt(i)=='I'){
                if((i+1)<s.length() && s.charAt(i+1)=='X'){
                n+=9;
                i++;
                continue;
                }
                else if((i+1)<s.length() && s.charAt(i+1)=='V'){
                    n+=4;
                    i++;
                    continue;
                }
                else{
                n+=1;
                continue;}
            }
            if(s.charAt(i)=='V'){
            n+=5;
            continue;}
        }
        return n;
    }
}
class LCM8StringToInteger{
        //TC->O(n) , sc->O(1)
        long ans = 0;
        int sign = 1;
        int i = 0,len =s.length();

        // Skipping leading whitespace
        while (i < s.length() && s.charAt(i) == ' ') i++;

        // Getting Sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && s.charAt(i)>='0'  && s.charAt(i)<='9') {
            ans = (ans * 10) + (s.charAt(i) - '0');
            if (ans * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            if (ans * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }

        return (int) ans * sign;

        // TC->O(n) , SC->O(1)
        // StringBuffer sb = new StringBuffer();
        // int sign =0,ans=0;
        // for(int i=0;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(ch == ' ' && (i==0 || s.charAt(i-1)==' ')) continue;
        //     else if(ch == '-' && (i==0 || (i!=0 && s.charAt(i-1) == ' '))) sign = 1;
        //     else if(ch == '+' && (i==0 || (i!=0 && s.charAt(i-1) == ' '))) sign = 0;
        //     else if(ch>='0'  && ch<='9' ) sb.append(ch);
        //     else break;
        // }

        // for(int i=0;i<sb.length();i++){
        //     int val = sb.charAt(i)-48;
        //     if(sign==0 && (ans > (Integer.MAX_VALUE - val)/10)) { ans = Integer.MAX_VALUE ; break;}
        //     if(sign==1 && (-1*ans < (Integer.MIN_VALUE + val)/10)) { ans = Integer.MIN_VALUE ; break;}
        //     ans = 10*ans + val;
        // }
        // return sign==1 ? (-1*ans) : ans ;

}
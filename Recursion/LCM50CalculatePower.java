class LCM50CalculatePower{
    double calPower(double x, long m){
        System.out.println(x +" "+m);
        if(m==0) return 1.0;
        double halfPowerValue = calPower(x,m/2);
        if(m%2==1){
            return halfPowerValue * halfPowerValue * x;
        }
        else{
            return halfPowerValue * halfPowerValue;
        }
    }
    public double myPow(double x, int n) {
        //Using Recursion TC->O(logn) SC->O(logn)
        long m = n;
        if(m<0) { x = 1/x ; m = -m;}
        return calPower(x,m);

        //Normal Approach : TC->O(logn); SC->O(1);
        // double ans = 1.0;
        // long m = n;
        // if(m<0) {m = -m; x = 1/x;}
        // System.out.println(m+" "+x);
        // int cnt=0;
        // while(m!=0)
        // {
        //     if(m%2==1){
        //         ans = ans*x;
        //         m--;
        //     }   
            
        //     else{
        //         x = x*x;
        //         m/=2;
        //     }
        // }
        // return ans;
    }
}
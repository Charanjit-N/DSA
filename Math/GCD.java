
//Optimal : Iterative using  Euclidean Algo (Iterative Better than recursive as no recursion overhead and stack space)
//TC-->O(log(min(a,b)))
int getGCD(int a, int b){
    while(a>0 && b>0){
        if(a>b) a = a%b;
        else  b = b % a;
    }
    if(a ==0) return b;
    else return a;
}

//Optimal :  Recursion using  Euclidean Algo 
//TC-->O(log(min(a,b))) , SC-->O(log(min(a,b)))
int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
}

//Brute :  TC -->O(Min(a,b))
int getGCD(int a, int b){
    int gcd = 1;
    for(int i=Math.min(a,b);i>=1;i--){
        if(a%i == 0 && b%i ==0){
            gcd = i;
            break;
        }
    }
    return gcd;
}


    







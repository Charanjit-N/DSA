class Basic{
    //approach 1 
    // static void func(int i, int n){
    //     if(i>n) return;
    //     System.out.println(i);
    //     func(i+1,n);
    // }

    //approach 2
    // static void func(int i, int n){
    //     if(i<1) return ;
    //     func(i-1,n);
    //     System.out.println(i);
    // }

    
    // static int fibo(int n){
    //     if(n<=1) return n;
    //     return fibo(n-1) + fibo(n-2);
    // }

    // parameterised way
    // static void calSum(int i, int sum){
    //     if(i<1){
    //         System.out.println(sum);
    //         return;
    //     }
    //     calSum(i-1,sum+i);
    // }
    
    // functional way
    // static int calSum(int n){
    //     if(n==0){
    //         return 0;
    //     }
    //     return n + calSum(n-1);
    // }

    // functional way
    // static int fact(int n){
    //     if(n==1){
    //         return 1;
    //     }
    //     return n*fact(n-1);
    // }

    // parameterised way
    // static void fact(int n, int ans){
    //     if(n==0){
    //         System.out.println(ans);
    //         return;
    //     }
    //     fact(n-1,ans*n);
    // }

    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
    }
    // static void reverseArray(int left, int right, int arr[]){
    //     if(left>=right) return;
    //     // swapping arr[left], arr[right];
    //     int temp = arr[left];
    //     arr[left] =  arr[right];
    //     arr[right] = temp;
        
    //     reverseArray(left+1, right-1, arr);
    // }

    // using single pointer variable
    static void reverseArray(int left, int arr[],int n){
        if(left==n/2) return;
        // swapping arr[left], arr[n-left-1];
        int temp = arr[left];
        arr[left] = arr[n-left-1];
        arr[n-left-1] = temp;
        
        reverseArray(left+1,arr,n);
    }


    public static void main(String args[]){

        //Print 1 to n numbers
        // int n = 5;
        // func(1,n);    //approach 1    Tc->O(n) {n recursion calls} SC->O(n) {for auxiliary stack space that store the wiating function calls}
        //func(n,n);    //approach 2

        //=================================================================================================================================
        /* 
            Finding the nth value in Fibonacci Series {0,1,1,2,3,5,8,....} strating from 0th value that is 0, 1st value is 1 , 2nd value is 1, 3rd value is 2...... 
            TC->O(2^n)   worst case : approx 2^n recursion calls happen. Can be optimized using Dynamic Programming.
        */
        // int n = 6;
        // System.out.println(fibo(n));  // 6th value in Fibonacci series is 8.

        // Using Dynamic Programming
        // int[] f = new int[n+1];
        // f[0] = 0; f[1]=1;
        // for(int i=2;i<=n;i++){
        //     f[i] = f[i-1]+f[i-2];
        // }
        // System.out.println(f[n]);

        //=================================================================================================================================
        /* Find the sum of 'n' numbers */
        // int n=3;
        // calSum(n,0);    // Parameterised way     {TC->O(n), SC->O(n)}
        // System.out.println(calSum(n));  // FUnctional way    {TC->O(n), SC->O(n)}

        //=================================================================================================================================
        // Find factorial of given number;
        // int n = 6;
        // fact(n,1);  // Parameterised way  {TC->O(n), SC->O(n)}
        // System.out.println(fact(n));  // FUnctional way   {TC->O(n), SC->O(n)}


        //=================================================================================================================================
        // Reverse an Array using recursion;
        int arr[] = {1,2,3,4,5,6,7};
        int n = arr.length;
        // reverseArray(0,n-1,arr);    // using two pointers
        reverseArray(0,arr,n);    // using single pointer variable
        printArray(arr);



    }
}
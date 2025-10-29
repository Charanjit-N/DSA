
import java.util.*;
public class CF327AFlippingGame{
    public static void main(String args[]){
        Scanner sc =  new Scanner(System.in);
        int n = sc.nextInt();
        int[]  a =  new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        int ones = 0;
        for(int i=0;i<n;i++){
            if(a[i]==0) a[i] = 1;
            else{
                ones++;
                a[i] = -1;
            }
        }
        // Kadane's Algorithm
        int sum = 0;
        int maxSum =  Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            sum += a[i];
            maxSum =  Math.max(sum, maxSum);
            if(sum <0){
                sum = 0;
            }
        }
        System.out.println(ones+maxSum);
    }
}
// TC->O(n * log R)
import java.util.Scanner;
public class CSES_FactoryMachines{
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        int ans = 0;
        int low = min, high = max*t;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(find(mid,a,t)){
                high = mid-1;
                ans = mid;
            }
            else{
                low =  mid+1;
            }
        }
        System.out.println(ans);
    }
    static boolean find(int time, int[] a, int t){
        int sum = 0;
        for(int x : a){
            sum += (time/x);
        }
        return sum >= t;
    }
}
import java.util.Scanner;
public class RemoveDigitsToMakeNextGreaterThanK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int have = sc.nextInt();  
        int want = sc.nextInt();  
        String s1 = Integer.toString(have);
        int n =  s1.length();
        String s2 =  Integer.toString(want);
        int k =  s2.length();
        System.out.println(n+" "+k);
        int [] ans =  {Integer.MAX_VALUE};
        // System.out.println("i,k,val ="+"0"+","+k+", 0");
        
        generateCombinations(0,n,k,0,want,s1,ans);

        if(ans[0] == Integer.MAX_VALUE){
            generateCombinations(0,n,k+1,0,want,s1,ans);
        }
        

        System.out.println(ans[0]);
    }

   

    
    static void generateCombinations(int start, int n, int k, int val, int want , String s, int[] ans) {
        if (k == 0) {
            if(val > want){
                ans[0] = Math.min(ans[0], val);
            }
            return;
        }
        if (start >= n) return;
        int num = val ;
        for (int i = start; i < n; i++) {
           num = 10*num + (s.charAt(i)-'0');
        //    System.out.println("i,k,val = "+(i+1)+","+(k-1)+","+num);
            generateCombinations(i + 1, n, k - 1, num,want,s,ans);
            num = val;
        }
    }
}

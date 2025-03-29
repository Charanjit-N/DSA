import java.util.Scanner;
class NumberPattern1{
   
    public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                System.out.print(n-j);
            }
            for(int j=0;j<2*(n-i)-2;j++){
                System.out.print(n-i);
            }
            for(int j=0;j<i;j++){
                System.out.print(n-i+j+1);
            }
            System.out.println();
        }


        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                System.out.print(n-j);
            }
            for(int j=0;j<2*i+1;j++){
                System.out.print(i+2);
            }
            for(int j=0;j<n-i-1;j++){
                System.out.print(i+j+2);
            }
            System.out.println();
        }
    }
}
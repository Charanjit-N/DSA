
/*
n = 5
    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA

n = 7
      A
     ABA
    ABCBA
   ABCDCBA
  ABCDEDCBA
 ABCDEFEDCBA
ABCDEFGFEDCBA
*/

class ABCPyramid{
    public static void main(String args[]){
        int n = 5;
        for(int i =1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(char ch = 'A' ; ch < 'A'+i;ch++){
                System.out.print(ch);
            }
            for(char ch = (char)('A'+i-2);ch>='A';ch-- ){
                System.out.print(ch);
            }
            System.out.println();
        }
        
    }
}


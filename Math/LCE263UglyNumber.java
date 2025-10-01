//Tc ->O(log n)
class Solution {
    public boolean isUgly(int n) {
        if(n <= 0) return false;
        long num = n;
        
       while(num > 1){
        while(num%2==0){
            num =  num/2;
            System.out.print(num+" ");
        }
        while(num%3==0){
            num =  num/3;
            System.out.print(num+" ");
            
        }
        while(num%5==0){
            num =  num/5;
            System.out.print(num+" ");
        }
        System.out.println("-------");

        if((num!=1)  && (num %2!=0 ||  num%3!=0 || num%5!=0)) return false;

       }
       return true;
    }
}
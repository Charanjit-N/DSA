
//TC ->O(k) k : numbers of set bits in n, SC->O(1)
class LCE191Numberof1Bits{
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n>0){
           n= n&(n-1);
           cnt++;
        }
        return cnt;    
    }
}

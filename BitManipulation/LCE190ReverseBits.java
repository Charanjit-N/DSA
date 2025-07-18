public class LCE190ReverseBits {
    // you need treat n as an unsigned value
    //  TC->O(n), SC->O(1)
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            int bit = n & 1;
            res =  (res<<1) | bit;
            n = n >>> 1;
        }
        return res;
    }
}

// Divide and Conquer , TC->O(1), SC->O(1)
public class LCE190ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n & 0xffff0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        
        return n;
    }
}
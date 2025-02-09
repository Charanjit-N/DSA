class LCE860LemonadeChange {

    // TC->O(N) , SC->O(1)
    public boolean lemonadeChange(int[] bills) {
        int fiveCnt = 0;
        int tenCnt =0;
        int twentyCnt =0;
        for(int num : bills){
            if(num == 5) fiveCnt++;
            else if(num == 10) {
                if(fiveCnt>0){
                    fiveCnt--;
                    tenCnt++;
                }
                else return false;
            }
            else{         //num = 20
             
                if(tenCnt>0 && fiveCnt>0){
                    tenCnt--;
                    fiveCnt--;
                }
                else if(fiveCnt>=3){
                    fiveCnt -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}
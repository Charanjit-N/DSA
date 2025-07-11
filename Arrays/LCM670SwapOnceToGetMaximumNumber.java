/*You are given an integer num. You can swap two digits at most once to get the maximum valued number.
Return the maximum valued number you can get.
*/
class LCM670SwapOnceToGetMaximumNumber{

    /* TC->O(4n)=(approx) O(n) {n-> length of the input num} , SC->O(1)
    Intution : Calculating the position of the digit(let say x) such that the digit to the right of it is greater that it. 
    Calculating the max digit(lets say z) to the right side of digit x and swapping it with 
    the leftmost digit that is < z , If no such digit obviously x will be replaced by z.
    */

    public int maximumSwap(int num) {
        int dup = num;
        int length = 0;
        int rev = 0;
        while(dup>0){
            rev = 10*rev + (dup%10);
            length++;
            dup/=10;
        }
        dup = rev;
        int pos = 0;
        int inc_pos = 0;
        while(dup>0){
            int r = dup%10;
            pos++;
            if(r < ((dup/10)%10)){
                inc_pos = pos;
                break;
            }
            dup/=10;
        }
        if(inc_pos == 0) return num;
        dup = rev;
        pos = 0;
        int maxToTheRight = Integer.MIN_VALUE;
        int maxToTheRight_pos = 0;
        while(dup>0){
            int r = dup%10;
            pos++;
            if(pos>inc_pos){
                if(r >= maxToTheRight){
                    maxToTheRight = r;
                    maxToTheRight_pos = pos;
                }
            }
            dup/=10;
        }
        dup = rev;
        pos = 0;
        int needToReplace_pos = 0;
        int needToReplace = 0;
        while(dup>0){
            int r = dup%10;
            pos++;
            if(maxToTheRight > r){
                needToReplace = r;
                needToReplace_pos = pos;
                break;
            }
            dup/=10;
        }
        int maxToTheRight_placeValue = length - maxToTheRight_pos;
        int needToReplace_placeValue = length - needToReplace_pos;        
        return (int)( 
               num 
               - (maxToTheRight*(Math.pow(10,maxToTheRight_placeValue))) 
               + (needToReplace*(Math.pow(10,maxToTheRight_placeValue))) 
               - (needToReplace*(Math.pow(10,needToReplace_placeValue))) 
               + (maxToTheRight*(Math.pow(10,needToReplace_placeValue)))
               );
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LCE160IntersectionOfTwoLLs{
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // Optimal:  TC->O(M+N) , SC->O(1)
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){
            tempA = tempA.next;
            tempB = tempB.next;
            if(tempA == tempB) return tempA;  // (or) return tempB;
            if(tempA==null) tempA = headB;
            if(tempB == null) tempB = headA;
        }
        return tempA; // (or) return tempB;

        // Better than the previous Better: TC->O(M+2N) , SC->O(1)
        // M->size of shorter LL , N-> size of Longer LL
        // ListNode tempA = headA;
        // int lenA=0;
        // while(tempA!=null){
        //     lenA++;
        //     tempA = tempA.next;
        // }

        // ListNode tempB = headB;
        // int lenB=0;
        // while(tempB!=null){
        //     lenB++;
        //     tempB = tempB.next;
        // }

        // if(lenB>lenA){
        //     int d = lenB-lenA;
        //     while(d>0){
        //         d--;
        //         headB=headB.next;
        //     }
        // }
        // else{
        //     int d = lenA-lenB;
        //     while(d>0){
        //         d--;
        //         headA=headA.next;
        //     }
        // }
        // while(headA!=null){
        //     if(headA==headB) return headA;
        //     headA = headA.next;
        //     headB = headB.next;
        // }
        // return null;

        // Better :  TC->O(M + N) , SC->O(M) (or) O(N)
        // ListNode tempA = headA;
        // Map<ListNode, Integer> map = new HashMap<>();
        // while(tempA!=null){
        //     map.put(tempA, tempA.val);
        //     tempA = tempA.next;
        // }
        // ListNode tempB = headB;
        // while(tempB!=null){
        //     if(map.containsKey(tempB)) return tempB;
        //     tempB = tempB.next;
        // }
        // return null;

        // Brute : TC-> O(MxN) , SC->O(1)
        // ListNode tempA = headA;
        // while(tempA!=null){
        //     ListNode tempB = headB;
        //     while(tempB!=null){
        //         if(tempA == tempB ) return tempA;
        //         tempB = tempB.next;
        //     }
        //     tempA = tempA.next;
        // }
        // return null;

        
        
    }
}
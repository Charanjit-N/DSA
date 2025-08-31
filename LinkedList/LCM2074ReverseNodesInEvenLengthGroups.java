//TC ->O(n), SC->O(1)
class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {

        if (head==null || head.next == null || head.next.next == null) return head;
        
        ListNode node =  head;
        int group = 1;
        while(node.next != null ){
            group++;
            int cnt = 0;
            ListNode temp = node.next;
            while(temp!=null && cnt<group){
                temp = temp.next;
                cnt++;
            }
        
            if(cnt % 2==0){
                ListNode temp1 =  node.next, prev = null;
                ListNode temp2 = temp1;

                for(int i=0;i<cnt;i++){
                    temp1 = temp1.next;
                    temp2.next = prev;
                    prev = temp2;
                    temp2 = temp1;
                }
                ListNode tail = node.next;
                node.next.next = temp1;
                node.next = prev;
                node= tail;
            }
            else{
                for(int i =0;i<cnt;i++){
                    node = node.next;
                }
            }
        }
        return head;
    }
}
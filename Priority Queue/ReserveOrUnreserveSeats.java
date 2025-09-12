/* 
Question : There are some number of seats given , and a array of operations given idicated by either 0 or 1, if the operation is 0 then reserve the lowest unreserved seat and if the operation is 1 then unreserve the lowest reserved seat. Return/print the seat number being reserved each as we perform all operations in given array of opeerations.
Ex : seats =  3 , ops[] = [0,0,0,1,0,1]
output = 1 2 3 1 
*/

// Adding -> O(log n )
//The retrieval and removal of the head element are performed in O(log⁡n) time 
// because the queue maintains a heap structure to keep elements ordered.
//Adding, Deleting from heap based Priority Queue -> O(log n)

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
class ReserveOrUnreserveSeats{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int seats = sc.nextInt();
        int opsLen = sc.nextInt();
        int[] ops = new int[opsLen];
        for(int i=0;i<opsLen;i++){
            ops[i] =sc.nextInt();
        }
        System.out.println(Arrays.toString(ops));
        PriorityQueue<Integer> unreserved = new PriorityQueue<>();
        PriorityQueue<Integer> reserved = new PriorityQueue<>();
        for(int i=1;i<=seats;i++){
            unreserved.add(i);
        }
        for(int i=0;i<ops.length;i++){
            if(ops[i]==0){
                System.out.println(unreserved.peek());
                reserved.add(unreserved.poll());
                
            }
            else{
                unreserved.add(reserved.poll());
            }
        }

    }
}
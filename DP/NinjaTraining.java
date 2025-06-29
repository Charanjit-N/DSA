
import java.util.Arrays;

// Recursion
// class NinjaTraining{
//     static int solve(int day, int lastTask, int[][] points){
//         if(day ==0){
//             int max = Integer.MIN_VALUE;
//             for(int i=0;i<3;i++){
//                 if(i!=lastTask){
//                     max =  Math.max(max, points[day][i] );
//                 }
//             }
//             return max;
//         }
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<3;i++){
//             if(i != lastTask){
//                 int val = points[day][i] + solve(day-1, i, points);
//                 max = Math.max(max, val);
//             }
//         }
//         return max;
//     }
//     public static void main(String args[]){
//         int[][] points = {{1,2,5},{3,1,1}, {3,3,3}};
//         int n = points.length;  
//         System.out.println(solve(n-1, 3, points));
//     }
// }




// Memoization  TC->O(n x 4 x 3) = O(n) , SC->O(n + 4n)
// class NinjaTraining{
//     static int solve(int day, int lastTask, int[][] points, int[][] dp){
//         if(day ==0){
//             int max = Integer.MIN_VALUE;
//             for(int i=0;i<3;i++){
//                 if(i!=lastTask) { max =  Math.max(max, points[day][i] ); } 
//             }
//             return max;
//         }
//         if(dp[day][lastTask] != -1)  return dp[day][lastTask];
//         int max = Integer.MIN_VALUE;
//         for(int i=0;i<3;i++){
//             if(i != lastTask){
//                 int val = points[day][i] + solve(day-1, i, points, dp);
//                 max = Math.max(max, val);
//             }
//         }
//         dp[day][lastTask] = max;
//         return  max;
//     }
//     public static void main(String args[]){
//         int[][] points = {{1,2,5},{3,1,1}, {3,3,3}};
//         int n = points.length;  
//         int[][] dp = new int[n][4];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         System.out.println(solve(n-1, 3, points,dp));
//     }
// }


// Tabulation space optimized TC -->O(n * 4 * 3), SC-->O(4) = O(1)
class NinjaTraining{
    public static void main(String args[]){
        int[][] points = {{1,2,5},{3,1,1}, {3,3,3}};
        int n = points.length;  
        int[] prev = new int[4];
        prev[0] = Math.max(points[0][1] , points[0][2]);
        prev[1]  =Math.max(points[0][0] , points[0][2]);
        prev[2] = Math.max(points[0][0] , points[0][1]);
        prev[3]  = Math.max(points[0][0], Math.max(points[0][1] , points[0][2]));
        for(int day=1;day<n;day++){
            int[] temp =  new int[4];
            for(int lastTask=0; lastTask<4; lastTask++){
                int max = Integer.MIN_VALUE;
                for(int task=0;task<3;task++){
                    if(task != lastTask){
                        int val = points[day][task] + prev[task];
                        max = Math.max(max, val);
                    }
                }
                temp[lastTask] = max;
            }
            for(int i=0;i<4;i++){
                prev[i] =  temp[i];
            }
        }
        System.out.println(prev[3]);
    }
}
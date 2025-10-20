class Solution {
    int comp(String a, String b ){
        String x =  a+b;
        String y =  b+a;
        int n =  x.length();
        for(int i=0;i<n;i++){
            char ch1 = x.charAt(i);
            char ch2 =  y.charAt(i);
            if(ch1>ch2) return -1;
            else if(ch1 < ch2) return 1;
        }
        return 0;
    }
    public String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a,b) -> comp(a,b));

        StringBuilder sb =  new StringBuilder();
        boolean bn = false;
        for(String x :  arr){
            if(!x.equals("0")) bn = true;
            sb.append(x);
        }
        if(bn == false) return "0";

        return sb.toString();
    }
}

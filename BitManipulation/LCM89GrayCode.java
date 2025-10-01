//n-> # bits
// TC -> O(2^n), SC->O(2^n)
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> gc =  new ArrayList<>();
        for(int i=0 ;i<(1<<n);i++){
            gc.add(i ^ (i>>1));
        }
        return gc;
    }
}


// uSing Recursion
// TC -> O(2^n), SC->O(2^n)
class Solution {
    public List<Integer> grayCode(int n) {

        List<String> gcStrings = generate(n , (1<<n));
        List<Integer> gc =  new ArrayList<>();
        for(int i=0;i<(1<<n);i++){
            gc.add(Integer.parseInt(gcStrings.get(i), 2));
        }
        return gc;
    }
    List<String> generate(int n , int tot){
        if(n==1) return new ArrayList<>(Arrays.asList("0" ,"1"));
        List<String> gcStrings = generate(n-1,tot/2);
        List<String> ans =  new ArrayList<>();

        for(int i=0;i< tot/2;i++){
            ans.add("0"+gcStrings.get(i));
        }

        for(int i=tot/2-1;i>=0;i--){
            ans.add("1"+gcStrings.get(i));
        }
        return ans; 
    }
}
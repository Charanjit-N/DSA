class LCE58LengthofLastWord {
    // TC->O(n)
    public int lengthOfLastWord(String s) {
        String[] arr = s.split("\\s+");
        return arr[arr.length-1].length();
        
    }
}
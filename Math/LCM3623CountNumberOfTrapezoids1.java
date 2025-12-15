class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int mod =  (int)1e9 + 7;
        long res = 0;
        long sum = 0;
        for (int[] point : points) {
            map.put(point[1], map.getOrDefault(point[1], 0) + 1);
        }
        for (int x : map.values()) {
            long possibleSides = ((long) x * (x - 1)) / 2;  // xC2
            res = (res + possibleSides * sum) % mod;
            sum = (sum + possibleSides) % mod;
        }
        return (int) res;
    }
}


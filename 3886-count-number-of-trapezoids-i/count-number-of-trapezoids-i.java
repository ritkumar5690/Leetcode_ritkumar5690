class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = points.length;
        for (int[] point: points) {
            int y = point[1];
            map.put(y,map.getOrDefault(y,0)+1);
        }
        long res = 0L;
        long prevHcount = 0L;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            long count = it.getValue();
            long horiCount = count * (count-1)/2L;
            res = (res + (horiCount % MOD) * (prevHcount % MOD)) % MOD;
            prevHcount = (prevHcount + horiCount) % MOD;
        }
        return  (int)res;

    }
}
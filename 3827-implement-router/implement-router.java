class Router {
    LinkedList<List<Integer>> que;
    Map<Integer, List<Integer>> map;
    private int n;
    Set<String> dup;
    public Router(int memoryLimit) {
        n = memoryLimit;
        que = new LinkedList<>();
        map = new HashMap<>();
        dup = new HashSet<>();
    }
    private String code(int source, int destination, int timestamp){
        return source + "-" + destination + "-" + timestamp;
    }
    public boolean addPacket(int source, int destination, int timestamp) {

        List<Integer> list = Arrays.asList(source, destination, timestamp);
        String key = code(source, destination, timestamp);
        if (dup.contains(key)) return false;

        if (que.size() >= n) {
            List<Integer> removed = que.poll();
            int reDest = removed.get(1);
            List<Integer> restamps = map.get(reDest);

            restamps.remove(0);
            dup.remove(code(removed.get(0), reDest, removed.get(2)));

        } 
        que.add(list);
        dup.add(key);
        map.putIfAbsent(destination, new ArrayList<>());
        map.get(destination).add(timestamp);

        return true;
    }

    public int[] forwardPacket() {
        if (que.isEmpty()) {
            return new int[] {};
        }
        List<Integer> list = que.poll();
        final int destination = list.get(1);
        List<Integer> listm = map.get(destination);
        listm.remove(0);
        dup.remove(code(list.get(0), destination, list.get(2)));

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = map.get(destination);
        if (list == null || list.isEmpty()) return 0;
        int left = lowerBound(list, startTime);
        int right = upperBound(list, endTime);

        return right - left;
    }

    private int lowerBound(List<Integer> list, int target) {
        int s = 0, e = list.size();
        while (s < e) {
            int m = s + (e - s) / 2;
            if (list.get(m) >= target) e = m;
            else s = m + 1;
        }
        return s;
    }

    private int upperBound(List<Integer> list, int target) {
        int s = 0, e = list.size();
        while (s < e) {
            int m = s + (e - s) / 2;
            if (list.get(m) > target) e = m;
            else s = m + 1;
        }
        return s;
    }

}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */
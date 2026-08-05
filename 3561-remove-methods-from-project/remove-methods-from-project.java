class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        boolean suspicius[] = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] num : invocations) {
            int u = num[0];
            int v = num[1];
            graph.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> que = new LinkedList<>();
        que.offer(k);
        suspicius[k] = true;

        while (!que.isEmpty()) {
            int curr = que.peek();
            que.poll();
            for (int i : graph.get(curr)) {
                indegree[i]--;
                if (!suspicius[i]) {
                    suspicius[i] = true;
                    que.offer(i);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (suspicius[i] && indegree[i] != 0) {
                flag = true;
            }
        }
        if (flag) {
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (!suspicius[i]) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
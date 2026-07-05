class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        List<List<Edge>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int[] road : edges) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            indegree[v]++;
            graph.get(u).add(new Edge(v, w));
        }
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
             int u = q.poll();
                topo.add(u);
            for (Edge e : graph.get(u)) {
                if (--indegree[e.target] == 0)
                    q.offer(e.target);
            }
        }
        int left = 0, right = 1_000_000_000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long INF = Long.MAX_VALUE / 4;
            long[] dp = new long[n];
            Arrays.fill(dp, INF);
            dp[0] = 0;

            for (int u : topo) {

                if (dp[u] == INF)
                    continue;

                if (u != 0 && u != n - 1 && !online[u])
                    continue;

                for (Edge e : graph.get(u)){
                    int v = e.target;
                    int w = e.weight;

                    if (w < mid)
                        continue;

                    if (v != n - 1 && !online[v])
                        continue;

                    dp[v] = Math.min(dp[v], dp[u] + w);
                }
            }

            if (dp[n - 1] <= k) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }
}

class Edge {
    int target;
    int weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}
class Solution {
    public int minScore(int n, int[][] roads) {

    List<List<Edge>> graph = new ArrayList<>();

    for(int i=0;i<=n;i++)
        graph.add(new ArrayList<>());

    for(int[] road : roads){
        graph.get(road[0]).add(new Edge(road[1], road[2]));
        graph.get(road[1]).add(new Edge(road[0], road[2]));
    }

    boolean[] visited = new boolean[n+1];

    Queue<Integer> q = new LinkedList<>();

    q.offer(1);
    visited[1] = true;

    int ans = Integer.MAX_VALUE;

    while(!q.isEmpty()){

        int u = q.poll();

        for(Edge e : graph.get(u)){

            ans = Math.min(ans, e.weight);

            if(!visited[e.target]){
                visited[e.target] = true;
                q.offer(e.target);
            }
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

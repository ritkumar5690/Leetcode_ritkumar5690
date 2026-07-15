class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        boolean visited[] = new boolean[n];
        
        for(int i =0;i<n;i++){
           if(visited[i]) continue;
           int info[] = new int[2];

           dfs(i, graph, visited, info);

           if(info[0] * (info[0]-1) == info[1]){
            count++;
           }
        }
        return count;
    }

    private void dfs(int i, Map<Integer,List<Integer>> graph, boolean[] visited, int[] info){
        visited[i] = true;
        info[0]++;
        info[1] += graph.getOrDefault(i, new ArrayList<>()).size();

        for(int ng : graph.getOrDefault(i, new ArrayList<>())){
            if(!visited[ng]){
                dfs(ng, graph, visited, info);
            }
        }
    }

}

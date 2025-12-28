class Solution {
    private HashMap<Integer, List<Integer>> children;
    private int N;
    private HashMap<Long, Integer> count;
    private int[] sizes;
    private long max;
    
    public int countHighestScoreNodes(int[] parents) {
        max = 0;
        N = parents.length;
        children = new HashMap<>();
        count = new HashMap<>();
        
        // get the children for a node
        for(int i = 1; i < N; i++){
            children.putIfAbsent(parents[i], new ArrayList<>());
            children.get(parents[i]).add(i);
        }
        
        sizes = new int[N];
        dfs(0);
        
        return count.get(max);
    }
    
    
    private int dfs(int node){
        if(sizes[node] > 0) return sizes[node];
        
        long product = 1;
        
        if(!children.containsKey(node)){
            sizes[node] = 1;
            product = N - 1;
        } else {
            for(int child : children.get(node)){
                int sizeChild = dfs(child);
                sizes[node] += sizeChild;
                product *= sizeChild;
            }
            sizes[node]++;
            product *= Math.max(1, N - sizes[node]);
        }
        
        count.put(product, count.getOrDefault(product, 0) + 1);
        max = Math.max(max, product);
        
        return sizes[node];
    }
    
}
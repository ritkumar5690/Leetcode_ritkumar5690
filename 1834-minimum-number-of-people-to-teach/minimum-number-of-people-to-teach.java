class Solution {
    public int minimumTeachings(int n, int[][] language, int[][] friend) {
        int n1 = language.length;
        Set<Integer>[] lang = new HashSet[n1];
        for(int i =0;i<n1;i++){
            lang[i] = new HashSet<>();
            for(int l : language[i]){
                lang[i].add(l);
            }
        }
        Set<Integer> tech = new HashSet<>();
        for(int[] num : friend){
            int u = num[0]-1;
            int v = num[1]-1;
            if(!common(lang[u], lang[v])){
                tech.add(u);
                tech.add(v);
            }
        }

        if(tech.isEmpty()) return 0;

        int res = Integer.MAX_VALUE;
        for(int i = 1;i<= n ;i++){
            int count = 0;
            for(int num : tech){
                if(lang[num].contains(i)){
                    count++;
                }
            }
            res = Math.min(res,tech.size()-count);
        }
        return res;
    }

    private boolean common(Set<Integer> f1,Set<Integer> f2){
        for(int n : f1){
            if(f2.contains(n)){
                return true;
            }
        }
        return false;
    }
}
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int res =0;
        int n=patterns.length;
        for(int i=0;i<n;i++){
            if(word.contains(patterns[i])) res++;
        }
        return res;
    }
}
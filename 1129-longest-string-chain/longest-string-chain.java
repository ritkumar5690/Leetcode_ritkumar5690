class Solution {
    Integer t[][];
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        int n = words.length;
        t = new Integer[n][n + 1];
        return solve(words,0,-1);
    }
    private int solve(String[] words, int i,int p){
        if(i == words.length) return 0;
        if(t[i][p+1]!= null){
            return t[i][p+1];
        }
        int take = 0;
        if(p == -1 || isPredecessor(words[p], words[i])){
            take = 1 + solve(words,i+1,i);
        }
        int skip = solve(words,i+1,p);
        return t[i][p+1] = Math.max(take,skip);
    }
    private boolean isPredecessor(String shortWord, String longWord) {

    if (longWord.length() != shortWord.length() + 1) {
        return false;
    }

    int i = 0;
    int j = 0;

    while (i < shortWord.length() && j < longWord.length()) {

        if (shortWord.charAt(i) == longWord.charAt(j)) {
            i++;
        }

        j++;
    }

    return i == shortWord.length();
}
}
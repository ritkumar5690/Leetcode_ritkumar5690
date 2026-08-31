class Solution {
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)-> a.length()-b.length());
        int n = words.length;

        int t[] = new int[n];
        Arrays.fill(t,1);
        int maxL = 1;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(isPredecessor(words[j], words[i])){
                    t[i] = Math.max(t[i], t[j]+1);
                    maxL = Math.max(maxL,t[i]);
                }
            }
        }
        return maxL;
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
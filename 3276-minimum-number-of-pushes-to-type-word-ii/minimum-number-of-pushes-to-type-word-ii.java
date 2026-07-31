class Solution {
    public int minimumPushes(String word) {
        int count[] = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'a']++;
        }
        Arrays.sort(count);
        int k = 1, ans = 0;
        int cnt = 0, key = 1;
        for (int i = 25; i >= 0; i--) {
            if(count[i] == 0) {
                break;
            }
            ans += count[i]*key;
            cnt++;
            if(cnt % 8 == 0){
                key++;
            }
        }
        return ans;
    }

}
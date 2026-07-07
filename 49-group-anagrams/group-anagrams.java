class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i =0;i<strs.length;i++){
            if(set.contains(i)) continue;
            String s = strs[i];
            List<String> list = new ArrayList<>();
            list.add(s);
            for(int j =i+1;j<strs.length;j++){
                String t = strs[j];
                if(check(s,t)){
                    list.add(t);
                    set.add(j);
                }
            }
            res.add(list);
        }
        return res;
    }
    private boolean check(String s, String t){
        if(s.length() != t.length()) return false;
        int freq[] = new int[26];
        for(int i =0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int cnt : freq) {
            if(cnt !=0) return false;
        }
        return true;
    }
}
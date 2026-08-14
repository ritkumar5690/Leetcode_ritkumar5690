class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Integer,Integer> map = new HashMap<>();
        int j = 0;
        int res = 0;
        for(int i = 0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            map.put(index,map.getOrDefault(index,0)+1);
            while(map.get(index) > 2){
                int index2 = s.charAt(j)-'a';
                map.computeIfPresent(index2, (key,value) -> value > 1 ? value-1 :null);
                j++;
            }
            res = Math.max(res, i-j+1);
        }
        return res;
    }
}
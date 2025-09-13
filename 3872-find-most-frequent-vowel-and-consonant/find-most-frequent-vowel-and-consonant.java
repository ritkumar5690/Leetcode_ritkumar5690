class Solution {
    public int maxFreqSum(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int m1=0,m2=0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (isVowel(ch)) {
                if (map.containsKey(ch)) {
                    map.compute(ch, (key, oldValue) -> oldValue + 1);
                } else {
                    map.put(ch, 1);
                }
            } else {
                if (map2.containsKey(ch)) {
                    map2.compute(ch, (key, oldValue) -> oldValue + 1);
                } else {
                    map2.put(ch, 1);
                }
            }
        }
        Map.Entry<Character, Integer> maxEntry1 = map.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        Map.Entry<Character, Integer> maxEntry2 = map2.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
        if(maxEntry1!=null){
               m1 = maxEntry1.getValue();
        }
        if(maxEntry2!=null){
               m2 = maxEntry2.getValue();
        }
        return m1+m2;
    }

    private boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
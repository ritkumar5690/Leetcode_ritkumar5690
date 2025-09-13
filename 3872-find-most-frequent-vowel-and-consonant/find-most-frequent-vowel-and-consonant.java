class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch =  s.charAt(i);
			
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				
            	map1.put(ch, map1.getOrDefault(ch, 0)+1);
      
			}else {
            	map2.put(ch, map2.getOrDefault(ch, 0)+1);
			}
        }
        int count1 = 0;
		for(int c : map1.values()) {
			count1 = Math.max(c, count1);
		}
		
		int count2 = 0;
		for(int c : map2.values()) {
			count2 = Math.max(c, count2);
		}
		
		
		return count1 +  count2;
    }
}